package com.homegrown.adventofcode.day8

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day8Test{
    val day = "day8"

    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return 21 trees are visible `() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day8().solve1(readLines, 5)).isEqualTo(21)
        }

        @Test
        fun `actual input should return 1798 trees are visible `() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day8().solve1(readLines,99))
            AssertionsForInterfaceTypes.assertThat(Day8().solve1(readLines,99)).isEqualTo(1798)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return scenic score 8`() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day8().solve2(readLines, 5)).isEqualTo(8)
        }

        @Test
        fun `actual input should return scenic score 259308 `() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day8().solve2(readLines, 99))
            AssertionsForInterfaceTypes.assertThat(Day8().solve2(readLines,99)).isEqualTo(259308)
        }

    }
}