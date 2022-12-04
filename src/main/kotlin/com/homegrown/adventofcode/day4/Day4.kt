package com.homegrown.adventofcode.day4;


typealias PairOfElves = Pair<Section, Section>

class Day4 {

    fun solve1(input: List<String>): Int {
        return input
            .asSequence()
            .map(::getPairOfElves)
            .filter(::doesFullyContainSection)
            .count()

    }

    fun solve2(input: List<String>): Int {
        return input
            .asSequence()
            .map(::getPairOfElves)
            .filter(::doesPartiallyContainSection)
            .count()
    }

    private fun getPairOfElves(section: String): PairOfElves {
        val elves = section.split(",")
        val elf1 = elves[0].split("-")
        val elf2 = elves[1].split("-")
        return PairOfElves(
            Section(elf1[0].toInt(), elf1[1].toInt()),
            Section(elf2[0].toInt(), elf2[1].toInt())
        )
    }

    private fun doesFullyContainSection(elfPair: PairOfElves): Boolean {
        return elfPair.first.wrappedBySection(elfPair.second)
                || elfPair.second.wrappedBySection(elfPair.first)
    }

    private fun doesPartiallyContainSection(elfPair: PairOfElves): Boolean {
        return elfPair.first.overlapsSection(elfPair.second)
                || elfPair.second.overlapsSection(elfPair.first)
    }

}

class Section(private val startIndex: Int, private val endIndex: Int) {

    // TODO: Can we override the in function to use the Section object
    fun wrappedBySection(wrappingSection: Section): Boolean{
        return this.startIndex in (wrappingSection.startIndex..wrappingSection.endIndex)
                && endIndex in (wrappingSection.startIndex..wrappingSection.endIndex)
    }

    fun overlapsSection(wrappingSection: Section): Boolean{
        return this.startIndex in (wrappingSection.startIndex..wrappingSection.endIndex)
                || endIndex in (wrappingSection.startIndex..wrappingSection.endIndex)
    }
}



