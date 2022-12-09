package com.homegrown.adventofcode.day9

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day9Test{
    val day = "day9"

    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return 13 positions `() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day9().solve1(readLines, 10)).isEqualTo(13)
        }

        @Test
        fun `actual input should return 6494 positions `() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day9().solve1(readLines, 10000))
            AssertionsForInterfaceTypes.assertThat(Day9().solve1(readLines, 10000)).isEqualTo(6494)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return 1 position `() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day9().solve2(readLines, 10)).isEqualTo(1)
        }

        @Test
        fun `actual input should return 2691 positions `() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day9().solve2(readLines, 10000))
            AssertionsForInterfaceTypes.assertThat(Day9().solve2(readLines, 10000)).isEqualTo(2691)
        }

    }
}