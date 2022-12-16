package com.homegrown.adventofcode.day11

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day11Test {
    val day = "day11"

    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return 10605 as monkey business `() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day11().solve1(readLines)).isEqualTo(10605L)
        }

        @Test
        fun `actual input should return 56595 as monkey business`() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day11().solve1(readLines))
            AssertionsForInterfaceTypes.assertThat(Day11().solve1(readLines)).isEqualTo(56595L)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return 2713310158 as monkey business`() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day11().solve2(readLines)).isEqualTo(2713310158L)
        }

        @Test
        fun `actual input should return as monkey business`() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day11().solve2(readLines))
            AssertionsForInterfaceTypes.assertThat(Day11().solve2(readLines)).isEqualTo(2691L)
        }

    }
}