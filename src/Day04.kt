fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        for (intervals in input) {
            val (first, second) = intervals.splitToIntervals()
            val intersection = first.intersect(second)
            if (intersection == first.toSet() || intersection == second.toSet()) sum++
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        for (intervals in input) {
            val (first, second) = intervals.splitToIntervals()
            if (first.intersect(second).isNotEmpty()) sum++
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}

private fun String.splitToIntervals(): Pair<IntRange, IntRange> {
    val (first, second) = this.split(",")
        .map { IntRange(it.substringBefore("-").toInt(), it.substringAfter("-").toInt()) }
    return Pair(first, second)
}