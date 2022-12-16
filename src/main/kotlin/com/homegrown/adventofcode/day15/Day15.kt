package com.homegrown.adventofcode.day15

import java.util.stream.IntStream
import kotlin.math.absoluteValue

class Day15(private val rowIndex: Int) {
    private lateinit var connections: List<Connection>

    fun solve1(input: List<String>): Int {
        connections = getConnections((input))

        connections = connections.stream().map { connection ->
            Connection(
                Location(connection.sensor.x - rowIndex, connection.sensor.y - rowIndex),
                Location(connection.beacon.x - rowIndex, connection.beacon.y - rowIndex)
            )
        }.toList()

        val intersections = findIntersections(0)
        val sensorCoverage = getSensorCoverageOnRow(0, intersections)
        val beaconsOnRow = beaconsOnRow(0, sensorCoverage)
        return sensorCoverage.size - beaconsOnRow.size

    }

    fun solve2(input: List<String>, maxValue: Int): Int {

        connections = getConnections((input))

        var result = Location(0, 0)
        for (i in 0..maxValue) {
            val intersections = findIntersections(i)
            val covered = getSensorCoverageOnRow(i, intersections).filter { x -> x in 0..maxValue }
            if (covered.size != maxValue + 1) {
                result = Location(
                    IntStream.range(0, maxValue + 1).filter { int -> !covered.contains(int) }.findFirst().orElse(0),
                    i
                )
            }

        }

        return result.x * 4000000 + result.y
    }

    private fun beaconsOnRow(rowIndex: Int, empty: MutableSet<Int>): Set<Location> {
        return connections
            .stream()
            .filter { connection ->
                val beaconOnRowY = connection.beacon.y == rowIndex
                val contains = empty.contains(connection.beacon.x)
                beaconOnRowY
                        && contains
            }
            .map { connection -> connection.beacon }
            .toList()
            .toSet()
    }

    private fun getConnections(input: List<String>): List<Connection> {

        return input
            .asSequence()
            .map { pair ->
                val xValues = Regex("(?<=x\\=)(.*?)(?=,)").findAll(pair).iterator()
                val yValues = Regex("(?<=y\\=)(.*?)(?=:)").findAll(pair).iterator()
                Connection(
                    Location(xValues.next().value.toInt(), yValues.next().value.toInt()),
                    Location(xValues.next().value.toInt(), yValues.next().value.toInt())
                )
            }
            .toList()
    }

    private fun getSensorCoverageOnRow(rowIndex: Int, intersections: List<Connection>): MutableSet<Int> {
        val sensorCoverage: MutableSet<Int> = HashSet()
        intersections
            .forEach { intersection ->
                val length =
                    intersection.distance - (intersection.sensor.y.absoluteValue - rowIndex.absoluteValue).absoluteValue
                for (i in intersection.sensor.x - length until intersection.sensor.x + length + 1) {
                    val loc = Location(i, intersection.sensor.y)
                    sensorCoverage.add(loc.x)
                }
            }
        return sensorCoverage
    }

    private fun findIntersections(rowIndex: Int): List<Connection> {
        return connections
            .stream()
            .filter { connection ->
                val test = connection

                val upCheck = listOf(connection.sensor.y, connection.sensor.y - connection.distance)
                val downCheck = listOf(connection.sensor.y, connection.sensor.y + connection.distance)


                val checkUp = rowIndex in upCheck.min()..upCheck.max()
                val checkDown = rowIndex in downCheck.min()..downCheck.max()
                checkUp || checkDown

            }
            .toList()
    }

    data class Location(val x: Int, val y: Int)
    data class Connection(val sensor: Location, val beacon: Location) {

        val distance: Int =
            (this.sensor.x - this.beacon.x).absoluteValue + (this.sensor.y - this.beacon.y).absoluteValue

    }

}



