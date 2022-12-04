package com.homegrown.adventofcode.day4

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day4Test {

    val day = "day4"

    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return 2 pairs `() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day4().solve1(readLines)).isEqualTo(2)
        }

        @Test
        fun `actual input should return 547 pairs`() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day4().solve1(readLines))
            AssertionsForInterfaceTypes.assertThat(Day4().solve1(readLines)).isEqualTo(547)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return 4 pairs`() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day4().solve2(readLines)).isEqualTo(4)
        }

        @Test
        fun `actual input should return 843 pairs`() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day4().solve2(readLines))
            AssertionsForInterfaceTypes.assertThat(Day4().solve2(readLines)).isEqualTo(843)
        }

    }
}