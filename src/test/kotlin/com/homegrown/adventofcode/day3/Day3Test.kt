package com.homegrown.adventofcode.day3

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day3Test {
    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return priority 157`() {
            val readLines: List<String> = "day3/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day3.solve1(readLines)).isEqualTo(157)
        }

        @Test
        fun `actual input should return priority 7811 `() {
            val readLines: List<String> = "day3/actualInput.txt".readLines()

            println(Day3.solve1(readLines))
            AssertionsForInterfaceTypes.assertThat(Day3.solve1(readLines)).isEqualTo(7811)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return priority 70 `() {
            val readLines: List<String> = "day3/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day3.solve2(readLines)).isEqualTo(70)
        }

        @Test
        fun `actual input should return priority 2639 `() {
            val readLines: List<String> = "day3/actualInput.txt".readLines()

            println(Day3.solve2(readLines))
            AssertionsForInterfaceTypes.assertThat(Day3.solve2(readLines)).isEqualTo(2639)
        }

    }
}