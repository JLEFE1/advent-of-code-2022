package com.homegrown.adventofcode.day15

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day15TestDay15Test {
    val day = "day15"

    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return 26`() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day15(10).solve1(readLines)).isEqualTo(26)
        }

        @Test
        fun `actual input should return 4502208`() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day15(2000000).solve1(readLines))
            AssertionsForInterfaceTypes.assertThat(Day15(2000000).solve1(readLines)).isEqualTo(4502208)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return 56000011`() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day15(10).solve2(readLines, 20)).isEqualTo(56000011)
        }

        @Test
        fun `actual input should return as monkey business`() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

//            println(Day15().solve2(readLines))
            AssertionsForInterfaceTypes.assertThat(Day15(10).solve2(readLines, 4000000)).isEqualTo(2691)
        }

    }
}