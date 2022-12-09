package com.homegrown.adventofcode.day9

import com.homegrown.adventofcode.common.Debugging
import com.homegrown.adventofcode.common.Debugging.debug

class Day9 constructor() {

    fun solve1(inputForest: List<String>, size: Int): Int {
        val head = Knot(KnotLocation(size.floorDiv(2), size.floorDiv(2)))
        val tail = Knot(KnotLocation(size.floorDiv(2), size.floorDiv(2)))
        val bridge = getBridge(size)
        bridge[tail.location.x][tail.location.y] = true

        inputForest.forEach { action ->
            val numberOfMoves = action.split(" ")[1].toInt()
            val typeOfMove = action.split(" ")[0]

            for (i in 0 until numberOfMoves) {
                moveHead(head, Action.valueOf(typeOfMove))
                tail.calcMove(head)
                tailWasHere(bridge, tail.location)
            }

        }

        return countTailVisits(bridge, size)
    }

    fun solve2(inputForest: List<String>, size: Int): Int {

        Debugging.disable()
        val bridge = getBridge(size)
        val rope = MutableList(10) { Knot(KnotLocation(size.floorDiv(2), size.floorDiv(2))) }
        bridge[rope[9].location.x][rope[9].location.y] = true

        inputForest.forEach { action ->
            val numberOfMoves = action.split(" ")[1].toInt()
            val typeOfMoves = action.split(" ")[0]

            for (i in 0 until numberOfMoves) {

                moveHead(rope[0], Action.valueOf(typeOfMoves))
                for (ropePart in 1 until 10) {
                    rope[ropePart].calcMove(rope[ropePart - 1])
                }
                tailWasHere(bridge, rope[9].location)
            }
        }

        return countTailVisits(bridge, size)
    }

    class Knot(var location: KnotLocation) {

        private fun isNeighbourOf(neighbour: Knot): Boolean {
            return location.x in neighbour.location.x - 1 until neighbour.location.x + 2
                    && location.y in neighbour.location.y - 1 until neighbour.location.y + 2
        }

        fun calcMove(neighbour: Knot) {
            if (!isNeighbourOf(neighbour)) {
                location = KnotLocation(
                    location.x + neighbour.location.x.compareTo(location.x),
                    location.y + neighbour.location.y.compareTo(location.y)
                )
            }
        }
    }

    enum class Action(val locationCorrection: KnotLocation) {
        R(KnotLocation(1, 0)),
        L(KnotLocation(-1, 0)),
        U(KnotLocation(0, -1)),
        D(KnotLocation(0, 1));

    }

    private fun moveHead(head: Knot, step: Action) {
        head.location = KnotLocation(
            head.location.x + step.locationCorrection.x,
            head.location.y + step.locationCorrection.y
        ).debug { "Head: ${head.location.x}, ${head.location.y}" }
    }

    private fun tailWasHere(bridge: Array<BooleanArray>, location: KnotLocation) {
        bridge[location.x][location.y] = true
    }

    private fun countTailVisits(bridge: Array<BooleanArray>, size: Int): Int {
        var count = 0;
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (bridge[i][j]) {
                    count++
                }
            }
        }
        return count
    }

    private fun getBridge(size: Int): Array<BooleanArray> {
        val bridge = Array(size) { BooleanArray(size) }
        for (i in 0 until size) {
            for (j in 0 until size) {
                bridge[i][j] = false
            }
        }
        return bridge
    }


}

data class KnotLocation(val x: Int, val y: Int)