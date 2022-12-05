package com.homegrown.adventofcode.day5

import com.homegrown.adventofcode.common.readLines
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day5Test {

    val day = "day5"

    @Nested
    inner class Puzzle1Tests {
        @Test
        fun `example input should return CMZ as top crates`() {
            val crates: List<String> = ("$day/testCrates.txt").readLines()
            val moves: List<String> = ("$day/testMoves.txt").readLines()

            AssertionsForInterfaceTypes.assertThat(Day5().solve1(crates, moves, 3)).isEqualTo("CMZ")
        }

        @Test
        fun `actual input should return WHTLRMZRC as top crates `() {
            val crates: List<String> = "$day/actualCrates.txt".readLines()
            val moves: List<String> = "$day/actualMoves.txt".readLines()

            println(Day5().solve1(crates, moves, 9))
            AssertionsForInterfaceTypes.assertThat(Day5().solve1(crates, moves, 9)).isEqualTo("WHTLRMZRC")
        }

    }

    @Nested
    inner class Puzzle2Tests {
        @Test
        fun `example input should return MCD as top crates`() {
            val crates: List<String> = ("$day/testCrates.txt").readLines()
            val moves: List<String> = ("$day/testMoves.txt").readLines()

            AssertionsForInterfaceTypes.assertThat(Day5().solve2(crates, moves, 3)).isEqualTo("MCD")
        }

        @Test
        fun `actual input should return GMPMLWNMG as top crates`() {
            val crates: List<String> = "$day/actualCrates.txt".readLines()
            val moves: List<String> = "$day/actualMoves.txt".readLines()

            println(Day5().solve2(crates, moves, 9))
            AssertionsForInterfaceTypes.assertThat(Day5().solve2(crates, moves, 9)).isEqualTo("GMPMLWNMG")
        }

    }
}