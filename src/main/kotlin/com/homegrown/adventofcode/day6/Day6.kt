package com.homegrown.adventofcode.day5;

import java.util.*

object Day6 {

    fun solve1(message: String): Int {
        return getLastCharOfEndOfMessageMarker(message, 4)

    }

    fun solve2(message: String): Int {
        return getLastCharOfEndOfMessageMarker(message, 14)
    }

    private fun getLastCharOfEndOfMessageMarker(message: String, markerSize: Int): Int {
        return message
            .windowed(markerSize)
            .withIndex()
            .first { indexedValue -> duplicateCount(indexedValue.value) == 0 }
            .index + markerSize
    }

    private fun duplicateCount(text: String): Int =
        text.lowercase(Locale.getDefault())
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }


}

