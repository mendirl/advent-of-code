package io.mendirl.adventofcode

class Day6 : Day() {
    override fun step1(inputs: List<String>): Int {
        return calcul(inputs) { it.reduce { a, b -> a.union(b) }.size }
    }

    override fun step2(inputs: List<String>): Int {
        return calcul(inputs) { it.reduce { a, b -> a.intersect(b) }.size }
    }

    private fun calcul(inputs: List<String>, policy: (List<Set<Char>>) -> Int): Int {
        return inputs.group().sumBy { policy(it) }
    }
}

private fun List<String>.group(): List<List<Set<Char>>> {
    return this.reduce { x, y -> "$x $y" }.split("  ")
        .map { it.split(" ").map { it.toSet() } }

}


