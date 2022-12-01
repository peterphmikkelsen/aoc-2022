import java.io.File

fun main() {
    fun part1(input: List<List<Int>>) = input.maxOf { it.sum() }

    fun part2(input: List<List<Int>>) = input.map(List<Int>::sum).sortedDescending().take(3).sum()

    // test if implementation meets criteria from the description, like:
    val testInput = readDayOneInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readDayOneInput("Day01")
    println(part1(input))
    println(part2(input))
}

private fun readDayOneInput(name: String): List<List<Int>> {
    return File("src", "$name.txt").readText()
        .split("\n\n")
        .map { it.replace("\n", " ") }
        .format()
}
private fun List<String>.format(): List<List<Int>> {
    return this.map { it.split(" ").map(String::toInt) }
}
