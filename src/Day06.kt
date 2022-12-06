
fun main() {
    fun part1(input: String): Int {
        return input.getPositionOfDistinctChars(4)
    }

    fun part2(input: String): Int {
        return input.getPositionOfDistinctChars(14)
    }

// test if implementation meets criteria from the description, like:
    val testInput = readLine("Day06_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 26)

    val input = readLine("Day06")
    println(part1(input))
    println(part2(input))
}

private fun String.getPositionOfDistinctChars(n: Int): Int {
    val window = this.windowed(n).map { it.toCharArray().toList() }.withIndex()
    for ((index, chars) in window)
        if (chars.toSet().size == chars.size) return index + n
    return 0
}