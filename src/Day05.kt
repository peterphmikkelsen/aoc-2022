
fun main() {
    val stacks = mutableListOf(
        ArrayDeque(listOf('T', 'D', 'W', 'Z', 'V', 'P')),
        ArrayDeque(listOf('L', 'S', 'W', 'V', 'F', 'J', 'D')),
        ArrayDeque(listOf('Z', 'M', 'L', 'S', 'V', 'T', 'B', 'H')),
        ArrayDeque(listOf('R', 'S', 'J')),
        ArrayDeque(listOf('C', 'Z', 'B', 'G', 'F', 'M', 'L', 'W')),
        ArrayDeque(listOf('Q', 'W', 'V', 'H', 'Z', 'R', 'G', 'B')),
        ArrayDeque(listOf('V', 'J', 'P', 'C', 'B', 'D', 'N')),
        ArrayDeque(listOf('P', 'T', 'B', 'Q')),
        ArrayDeque(listOf('H', 'G', 'Z', 'R', 'C')),
    )

    fun part1(input: List<String>): String {
        for (instruction in input) {
            if (!instruction.contains("move")) continue
            val (amount, from, to) = instruction.getClearInstructions()
            repeat(amount) {
                stacks[to - 1].addLast(stacks[from - 1].removeLast())
            }
        }
        return buildString {
            stacks.forEach { this.append(it.last()) }
        }
    }

    fun part2(input: List<String>): String {
        for (instruction in input) {
            if (!instruction.contains("move")) continue
            val (amount, from, to) = instruction.getClearInstructions()

            val fromStack = stacks[from - 1]
            val cratesToMove = fromStack.takeLast(amount)
            repeat(amount) {
                fromStack.removeLast()
            }
            stacks[to - 1].addAll(cratesToMove)
        }
        return buildString {
            stacks.forEach { this.append(it.last()) }
        }
    }

    val input = readInput("Day05")
//    println(part1(input))
    println(part2(input))
}

private fun String.getClearInstructions(): Triple<Int, Int, Int> {
    val (amount, from, to) = "\\d+".toRegex().findAll(this).map { it.value.toInt() }.toList()
    return Triple(amount, from, to)
}