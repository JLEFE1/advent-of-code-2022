package com.homegrown.adventofcode.day5

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day6Test {

    val day = "day6"

    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return index of last char of start of packet`() {
//            val readLines: List<String> = ("$day/testInput.txt").readLines()

            AssertionsForInterfaceTypes.assertThat(Day6.solve1("bvwbjplbgvbhsrlpgdmjqwftvncz")).isEqualTo(5)
            AssertionsForInterfaceTypes.assertThat(Day6.solve1("nppdvjthqldpwncqszvftbrmjlhg")).isEqualTo(6)
            AssertionsForInterfaceTypes.assertThat(Day6.solve1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")).isEqualTo(10)
            AssertionsForInterfaceTypes.assertThat(Day6.solve1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")).isEqualTo(11)
        }

        @Test
        fun `actual input should return 1598 as last char of packet marker `() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day6.solve1(readLines.first()))
            AssertionsForInterfaceTypes.assertThat(Day6.solve1(readLines.first())).isEqualTo(1598)
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return index of start of start message marker `() {
//            val readLines: List<String> = "$day/testInput.txt".readLines()

            AssertionsForInterfaceTypes.assertThat(Day6.solve2("mjqjpqmgbljsphdztnvjfqwrcgsmlb")).isEqualTo(19)
            AssertionsForInterfaceTypes.assertThat(Day6.solve2("bvwbjplbgvbhsrlpgdmjqwftvncz")).isEqualTo(23)
            AssertionsForInterfaceTypes.assertThat(Day6.solve2("nppdvjthqldpwncqszvftbrmjlhg")).isEqualTo(23)
            AssertionsForInterfaceTypes.assertThat(Day6.solve2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")).isEqualTo(29)
            AssertionsForInterfaceTypes.assertThat(Day6.solve2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")).isEqualTo(26)
        }

        @Test
        fun `actual input should return 2414 as index of start marker `() {
            val readLines: List<String> = "$day/actualInput.txt".readLines()

            println(Day6.solve2(readLines.first()))
            AssertionsForInterfaceTypes.assertThat(Day6.solve2(readLines.first())).isEqualTo(2414)
        }

    }
}