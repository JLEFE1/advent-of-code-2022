package com.homegrown.adventofcode.day3


object Day3 {

    fun solve1(rucksacks: List<String>): Int {

        return rucksacks
            // TODO: Proposed to make sequence. Why??
            .asSequence()
            .map(::getCompartments)
            .map(::getDuplicateItem)
            .map(::getPriority)
            .toList()
            .sum()
    }

    fun solve2(rucksacks: List<String>): Int {
        return rucksacks
            // TODO: Proposed to make sequence. Why??
            .asSequence()
            .chunked(3)
            .map(::getDuplicateItem)
            .map(::getPriority)
            .toList()
            .sum()
    }

    private fun getCompartments(rucksack: String): Pair<String, String> {
        return Pair(
            rucksack.substring(0 until rucksack.length / 2),
            rucksack.substring(rucksack.length / 2..rucksack.lastIndex)
        )
    }

    private fun getDuplicateItem(compartments: Pair<String, String>): Char {
        return compartments.first.asIterable().intersect(compartments.second.asIterable()).first();
    }

    private fun getDuplicateItem(rucksacks: List<String>): Char {
        return rucksacks[0].asIterable().intersect(rucksacks[1].asIterable().intersect(rucksacks[2].asIterable()))
            .first();
    }

    private fun getPriority(char: Char): Int {
        return when {
            char.isLowerCase() -> char.code - 96
            char.isUpperCase() -> char.code - 38
            else -> char.code
        }
    }

}