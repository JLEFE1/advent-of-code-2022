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
        for (marker in markerSize .. message.lastIndex) {
            if(duplicateCount(message.substring(marker - markerSize until marker)) == 0) {
                return marker
            }
        }
        throw IllegalArgumentException("Message does not contain end of message marker")
    }

    private fun duplicateCount(text: String): Int =
        text.lowercase(Locale.getDefault())
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }


}

