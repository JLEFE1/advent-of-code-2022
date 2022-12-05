package com.homegrown.adventofcode.day5;

typealias Move = Triple<Int, Int, Int>;

class Day5 {

    fun solve1(crates: List<String>, movesAsText: List<String>, numBerOfColumns: Int): String {

        var moves: MutableList<Move> = getMoves(movesAsText)
        val cratePile = getOriginalCratePile(crates, numBerOfColumns)

        moves.forEach { move ->
            for (step in 1..move.first) {
                val crate = cratePile[move.second - 1].removeFirst()
                cratePile[move.third - 1].subList(0, 0).add(crate)
            }
        }

        return getTopCrates(cratePile);
    }

    fun solve2(crates: List<String>, movesAsText: List<String>, numBerOfColumns: Int): String {
        var moves: MutableList<Move> = getMoves(movesAsText)
        val cratePile = getOriginalCratePile(crates, numBerOfColumns)

        moves.forEach { move ->
            var crateTest = cratePile[move.second - 1].subList(0,  move.first)
            cratePile[move.third - 1].subList(0, 0).addAll(crateTest)
            crateTest.clear()
        }

        return getTopCrates(cratePile);
    }

    private fun getMoves(movesAsText: List<String>): MutableList<Move> {
        var moves: MutableList<Move> = arrayListOf()
        movesAsText.forEach { value ->
            val t = value.split(" ")
            moves.add(Move(t[1].toInt(), t[3].toInt(), t[5].toInt()))
        }
        return moves
    }

    private fun getOriginalCratePile(crates: List<String>, numBerOfColumns: Int): Array<ArrayList<Char>> {
        val originalCratePile = Array(numBerOfColumns) { ArrayList<Char>() }
        crates.forEachIndexed { _, rowValue ->
            rowValue.chunked(4).forEachIndexed { columnIndex, columnValue ->
                if (columnValue.isNotBlank()) {
                    val column = originalCratePile[columnIndex]
                    column.add(columnValue[1])
                }
            }
        }
        return originalCratePile;
    }

    private fun getTopCrates(cratePile: Array<ArrayList<Char>>): String {
        var result = "";
        for (l in cratePile) {
            result += l.first()
        }
        return result;
    }

}
