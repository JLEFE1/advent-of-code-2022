package com.homegrown.adventofcode.day1


object Day1 {

    fun solve1(calories: List<String>): Int {
        var caloriesPerMinion = getCaloriesPerMinion(calories)
        return caloriesPerMinion.max();
    }

    fun solve2(calories: List<String>): Int {
        var caloriesPerMinion = getCaloriesPerMinion(calories)
        return caloriesPerMinion.sorted().takeLast(3).sum();
    }

    private fun getCaloriesPerMinion(calories: List<String>): ArrayList<Int> {

        // TODO: Find way to create lis of lists by splitting input list based on blank line
//        var indexesOfBlankLines = calories.withIndex().partition { it.value.isBlank() }.component1().stream().map { it.index }.toList()
//        var tttt = calories.slice(ttt).toList()

        var sum = 0
        var sums = ArrayList<Int>()
        for (calorie in calories) {

            if (calorie.isBlank()) {
                sums.add(sum)
                sum = 0

            } else {
                sum += calorie.toInt()
            }

        }
        sums.add(sum)
        return sums
    }


}