package com.homegrown.adventofcode.day2


object Day2 {

    fun solve1(games: List<String>): Int {
        return games.stream()
            .map(::toHands)
            .map (::calcScoreForGameWithTwoHands)
            .toList()
            .sum()
    }

        fun solve2(games: List<String>): Int {
            return games.stream()
                .map(::toHands)
                .map (::calcScoreForGameWithOutcome)
                .toList()
                .sum()
        }

    private fun toHands(game: String): Pair<String, String> {
        val hands = game.split(" ")
        return Pair(hands[0], hands[1])
    }

    private fun calcScoreForGameWithTwoHands(hands: Pair<String, String>): Int {
        val myChoice = Hand.getHand(hands.second)
        return myChoice.getScore(hands.first) + myChoice.points
    }

    private fun calcScoreForGameWithOutcome(handWithOutcome: Pair<String, String>): Int {
        val handForWantedOutcome = Hand.getHand(handWithOutcome.first).getHandForWantedOutcome(handWithOutcome.second)
        return handForWantedOutcome.points + getScoreForOutcome(handWithOutcome.second)
    }

    private fun getScoreForOutcome(outcome: String): Int {
        return when (outcome) {
            "X" -> 0
            "Z" -> 6
            else -> 3
        }
    }

    enum class Hand(val myHand: String, val points:Int, private val winFrom: String, private val loseFrom: String, val draw: String) {
        ROCK("X",  1, "C", "B", "A"),
        PAPER("Y",  2, "A", "C", "B"),
        SCISSOR("Z",   3, "B", "A", "C");

        fun getScore(oppositionsHand: String): Int {
            return when (oppositionsHand) {
                this.winFrom -> 6
                this.loseFrom -> 0
                else -> 3
            }
        }

        fun getHandForWantedOutcome(outcome: String): Hand {
            //X is loss, but we return win, because winfrom myHand equals lossfrom the opponents hand
            return when (outcome) {
                "X" -> Hand.getHand(this.winFrom)
                "Z" -> Hand.getHand(this.loseFrom)
                else -> Hand.getHand(this.draw)
            }
        }

        companion object {

            fun getHand(item: String): Hand {
                return when (item) {
                    "X" -> ROCK
                    "A" -> ROCK
                    "Y" -> PAPER
                    "B" -> PAPER
                    "Z" -> SCISSOR
                    "C" -> SCISSOR
                    else -> throw IllegalStateException("This hand does not exist. Perhaps try Rock Paper Scissors Lizard Spock")
                }
            }

        }

    }


}