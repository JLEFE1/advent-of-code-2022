package com.homegrown.adventofcode.day8

typealias TreeLocation = Pair<Int, Int>

class Day8 constructor() {

    fun solve1(inputForest: List<String>, side: Int): Int {
        var count = 0
        for (i in 0 until side) {
            for (j in 0 until side) {
                if (isHighestTree(getForest(inputForest, side), TreeLocation(i,j))) {
                    count++
                }
            }
        }
        return count
    }

    fun solve2(forest: List<String>, dimensions:Int): Int {

        val forest = getForest(forest, dimensions)

        var maxScenicScore = 0
        for (i in 0 until dimensions) {
            for (j in 0 until dimensions) {

                val visionToTheLeft = getTreesToTheLeft(forest, TreeLocation(i, j)).withIndex().find { index -> index.value >= forest[i][j]}?.let{ index -> index.value + 1} ?: j
                val visionToTheRight = getTreesToTheRight(forest, TreeLocation(i, j)).withIndex().find { index -> index.value >= forest[i][j] }?.let { index -> index.value + 1 } ?: (dimensions - 1 - j)
                val visionToTheTop = getTreesTotheTop(forest, TreeLocation(i, j)).reversed().withIndex().find { index -> index.value >= forest[i][j]}?.let{ index -> index.value + 1} ?: i
                val visionToTheBottom = getTreesToTheBottom(forest, TreeLocation(i, j)).withIndex().find { index -> index.value >= forest[i][j] }?.let { index -> index.value + 1 } ?: (dimensions - 1 - i)

                maxScenicScore = listOf(maxScenicScore, visionToTheLeft * visionToTheRight * visionToTheTop * visionToTheBottom).max()
            }
        }
        return maxScenicScore
    }

    private fun getForest(inputForest: List<String>, side:Int): Array<IntArray> {
        val forest = Array(side) { IntArray(side) }
        for (i in 0 until side) {
            for (j in 0 until side) {
                forest[i][j] = inputForest[i][j].digitToInt()
            }
        }
        return forest
    }

    private fun isHighestTree(forest: Array<IntArray>, treeLocation: TreeLocation): Boolean {
        return getTreesToTheLeft(forest, treeLocation).none { tree -> tree >= forest[treeLocation.first][treeLocation.second] }
                || getTreesToTheRight(forest, treeLocation).none { tree -> tree >= forest[treeLocation.first][treeLocation.second] }
                || getTreesTotheTop(forest, treeLocation).none { tree -> tree >= forest[treeLocation.first][treeLocation.second] }
                || getTreesToTheBottom(forest, treeLocation).none { tree -> tree >= forest[treeLocation.first][treeLocation.second] }
    }

    private fun getTreesToTheLeft(forest: Array<IntArray>, treeLocation: TreeLocation): MutableList<Int> {
        val trees: MutableList<Int> = ArrayList()
        for (i in 0 until treeLocation.second) {
            trees.add(forest[treeLocation.first][i])
        }
        return trees;
    }

    private fun getTreesToTheRight(forest: Array<IntArray>, treeLocation: TreeLocation): MutableList<Int> {
        val trees: MutableList<Int> = ArrayList()
        for (i in treeLocation.second + 1..forest.lastIndex) {
            trees.add(forest[treeLocation.first][i])
        }
        return trees;
    }

    private fun getTreesTotheTop(forest: Array<IntArray>, treeLocation: TreeLocation): MutableList<Int> {
        val trees: MutableList<Int> = ArrayList()
        for (i in 0 until treeLocation.first) {
            trees.add(forest[i][treeLocation.second])
        }
        return trees;
    }

    private fun getTreesToTheBottom(forest: Array<IntArray>, treeLocation: TreeLocation): MutableList<Int> {
        val trees: MutableList<Int> = ArrayList()
        for (i in treeLocation.first + 1..forest.lastIndex) {
            trees.add(forest[i][treeLocation.second])
        }
        return trees;
    }


}