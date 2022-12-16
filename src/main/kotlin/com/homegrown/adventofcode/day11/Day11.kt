package com.homegrown.adventofcode.day11

import org.springframework.expression.ExpressionParser
import org.springframework.expression.spel.standard.SpelExpressionParser


class Day11 {

    fun solve1(input: List<String>): Long {
        val monkeys = input.chunked(7).map { constructionLogicInput -> Monkey(constructionLogicInput) }.toList()

        repeat(20) {
            monkeys.stream().forEach { monkey -> monkey.throwItems(monkeys, 3L) }
        }

        return monkeys.asSequence().map { monkey -> monkey.itemsInspected }
            .toList()
            .sorted()
            .takeLast(2)
            .reduce { accumulator, element ->
                accumulator * element
            }
    }

    fun solve2(input: List<String>): Long {
        val monkeys = input.chunked(7).map { constructionLogicInput -> Monkey(constructionLogicInput) }.toList()
        val modulo = monkeys
            .map { it.test }
            .reduce { acc, i -> acc * i }
        var index = 0
        repeat(10000) {
            index++
            monkeys.stream().forEach { monkey -> monkey.throwInsaneBigItems(monkeys, modulo) }
        }

        return monkeys.asSequence().map { monkey -> monkey.itemsInspected }
            .toList()
            .sorted()
            .takeLast(2)
            .reduce { accumulator, element ->
                accumulator * element
            }
    }

}

class Monkey(constructionLogicInput: List<String>) {

    private val name: Long
    private val items: MutableList<Long>
    private val operation: String
    val test: Long
    private val trueCheck: Int
    private val falseCheck: Int
    private val constructionLogic: List<String> = constructionLogicInput
    private val parser: ExpressionParser = SpelExpressionParser()
    var itemsInspected: Long = 0L

    init {
        name = constructionLogic[0].split(" ")[1].split(":")[0].toLong()
        items = constructionLogic[1].split(": ")[1].split(", ").map { item -> item.toLong() }.toMutableList()
        operation = constructionLogic[2].split(" = ")[1]
        test = constructionLogic[3].split("by ")[1].toLong()
        trueCheck = constructionLogic[4].split("monkey ")[1].toInt()
        falseCheck = constructionLogic[5].split("monkey ")[1].toInt()
    }

    fun throwItems(monkeys: List<Monkey>, worryReducer: Long) {
        items.stream().forEach { item ->
            val parsedLevel =
                parser.parseExpression(String.format(operation.replace("old", "%s"), item, item)).value as Int
            val dividedWorryLevel: Long = parsedLevel.div(worryReducer)
            if (dividedWorryLevel.rem(test) == 0L) {
                monkeys[trueCheck].receiveItem(dividedWorryLevel)
            } else {
                monkeys[falseCheck].receiveItem(dividedWorryLevel)
            }

            itemsInspected++
        }
        items.clear()
    }

    fun throwInsaneBigItems(monkeys: List<Monkey>, modulo: Long) {
        items.stream().forEach { item ->
            var newWorryLevel = getNewValue(item, modulo)
            if (newWorryLevel.rem(test) == 0L) {
                monkeys[trueCheck].receiveItem(newWorryLevel)
            } else {
                monkeys[falseCheck].receiveItem(newWorryLevel)
            }
            itemsInspected++
        }
        items.clear()

    }

    private fun getNewValue(item: Long, modulo: Long): Long {
        return if (operation.contains("old * old")) {
            item % modulo * item % modulo
        } else if (operation.contains("+")) {
            item % modulo + operation.split("+ ")[1].toLong()
        } else {
            item % modulo * operation.split("* ")[1].toLong()
        }
    }

    private fun receiveItem(itemReceived: Long) {
        items.add(itemReceived)
    }


}



