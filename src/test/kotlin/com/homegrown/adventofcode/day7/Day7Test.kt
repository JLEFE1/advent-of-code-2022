package com.homegrown.adventofcode.day7

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day7Test {
    val day = "day7"

    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return 95437 `() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day7(readLines.iterator()).solve1()).isEqualTo(95437L)
        }

        @Test
        fun `actual input should return 1297683`() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day7(readLines.iterator()).solve1())
            AssertionsForInterfaceTypes.assertThat(Day7(readLines.iterator()).solve1()).isEqualTo(1297683L)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return 24933642`() {
            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day7(readLines.iterator()).solve2()).isEqualTo(24933642)
        }

        @Test
        fun `actual input should return 5756764`() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day7(readLines.iterator()).solve2())
            AssertionsForInterfaceTypes.assertThat(Day7(readLines.iterator()).solve2()).isEqualTo(5756764)
        }

    }
}