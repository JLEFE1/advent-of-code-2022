package com.homegrown.adventofcode.day1

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day1Test {

    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return 24000 calories`() {
            val readLines: List<String> = "day1/testInput.txt".readLines()

            assertThat(Day1.solve1(readLines)).isEqualTo(24000)
        }

        @Test
        fun `example input should return 70613 calories`() {
            val readLines: List<String> = "day1/actualInput.txt".readLines()

            assertThat(Day1.solve1(readLines)).isEqualTo(70613)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return 45000 calories`() {
            val readLines: List<String> = "day1/testInput.txt".readLines()

            assertThat(Day1.solve2(readLines)).isEqualTo(45000)
        }

        @Test
        fun `example input should return 205805 calories`() {
            val readLines: List<String> = "day1/actualInput.txt".readLines()
            assertThat(Day1.solve2(readLines)).isEqualTo(205805)
        }

    }
}