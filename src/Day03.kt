fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        for (item in input) {
            val (first, second) = item.chunked(item.length/2)
            sum += first.first(second::contains).alphabetPosition()
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        for (item in input.chunked(3)) {
            val (elf1, elf2, elf3) = item
            sum += elf1.first { elf2.contains(it) && elf3.contains(it) }.alphabetPosition()
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

private fun Char.alphabetPosition(): Int {
    val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return alphabet.indexOf(this) + 1
}