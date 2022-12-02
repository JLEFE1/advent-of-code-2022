package com.homegrown.adventofcode.day2

import com.homegrown.adventofcode.common.readLines
import com.homegrown.adventofcode.day1.Day1
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day2Test{
    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return 15 points`() {
            val readLines: List<String> = "day2/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day2.solve1(readLines)).isEqualTo(15)
        }

        @Test
        fun `example input should return 15632 points`() {
            val readLines: List<String> = "day2/actualInput.txt".readLines()

            println(Day2.solve1(readLines))
            AssertionsForInterfaceTypes.assertThat(Day2.solve1(readLines)).isEqualTo(15632)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return 12 points`() {
            val readLines: List<String> = "day2/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day2.solve2(readLines)).isEqualTo(12)
        }

        @Test
        fun `example input should return 14416 points`() {
            val readLines: List<String> = "day2/actualInput.txt".readLines()

            println(Day2.solve2(readLines))
            AssertionsForInterfaceTypes.assertThat(Day2.solve2(readLines)).isEqualTo(14416)
        }

    }
}