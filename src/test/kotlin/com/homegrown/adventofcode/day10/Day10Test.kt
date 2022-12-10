package com.homegrown.adventofcode.day10

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day10Test {
    val day = "day10"

    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return 13140 `() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day10().solve1(readLines)).isEqualTo(13140)
        }

        @Test
        fun `actual input should return 16480 `() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day10().solve1(readLines))
            AssertionsForInterfaceTypes.assertThat(Day10().solve1(readLines)).isEqualTo(16480)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return drawing `() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day10().solve2(readLines)).isEqualTo(1)
        }

        @Test
        fun `actual input should return drawing `() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

//            println(Day10().solve2(readLines))
            AssertionsForInterfaceTypes.assertThat(Day10().solve2(readLines)).isEqualTo(2691)
        }

    }
}