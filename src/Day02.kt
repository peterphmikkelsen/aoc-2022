fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        for (round in input) {
            val (opponent, us) = round.split(" ")
            sum += when(whoWins(opponent, us)) {
                true -> if (us == "X") 7 else if (us == "Y") 8 else 9
                false -> if (us == "X") 1 else if (us == "Y") 2 else 3
                null -> if (us == "X") 4 else if (us == "Y") 5 else 6
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        for (round in input) {
            val (opponent, us) = round.split(" ")
            sum += when (us) {
                "X" -> if (opponent == "A") 3 else if (opponent == "B") 1 else 2
                "Y" -> if (opponent == "A") 4 else if (opponent == "B") 5 else 6
                "Z" -> if (opponent == "A") 8 else if (opponent == "B") 9 else 7
                else -> 0
            }
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

private fun whoWins(opponent: String, us: String): Boolean? {
    if (opponent == us.mapToStandard()) return null
    return when(opponent) {
        "A" -> us == "Y"
        "B" -> us == "Z"
        "C" -> us == "X"
        else -> null
    }
}

private fun String.mapToStandard(): String {
    return when(this) {
        "X" -> "A"
        "Y" -> "B"
        "Z" -> "C"
        else -> ""
    }
}