package com.homegrown.adventofcode.day10

import com.homegrown.adventofcode.common.Debugging

class Day10 {

    fun solve1(input: List<String>): Int {
        val xRegister = populateXRegister(input)
        return xRegister[20] * 20 + xRegister[60] * 60 + xRegister[100] * 100 + xRegister[140] * 140 + xRegister[180] * 180 + xRegister[220] * 220
    }

    fun solve2(input: List<String>) {
        Debugging.disable()
        populateXRegister(input)
            .drop(1)
            .chunked(40).forEach { crtRow ->
                crtRow.forEachIndexed { index, position ->
                    if (index in position - 1..position + 1) print("#") else print(".")
                }
                println()
            }
    }

    private fun populateXRegister(input: List<String>): List<Int> {
        val xRegister: MutableList<Int> = arrayListOf(1)

        var valueToSet: Int? = null
        input.forEach { instruction ->

            valueToSet?.let { value -> xRegister.add(xRegister[xRegister.lastIndex] + value) } ?: xRegister.add(
                xRegister[xRegister.lastIndex]
            )

            valueToSet = if (!instruction.contains("noop")) {
                xRegister.add(xRegister[xRegister.lastIndex])
                instruction.split(" ")[1].toInt()
            } else {
                null
            }


        }
        return xRegister
    }

}
