package io.mendirl.adventofcode

class Day3 : Day {
    override fun step1(inputs: List<String>): Int {
        return calcul(inputs, 3, 1)
    }

    override fun step2(inputs: List<String>): Int {
        return listOf(
            calcul(inputs, 1, 1),
            calcul(inputs, 3, 1),
            calcul(inputs, 5, 1),
            calcul(inputs, 7, 1),
            calcul(inputs, 1, 2)
        )
            .reduce { x, y -> x * y }
    }

    private fun calcul(inputs: List<String>, right: Int, down: Int): Int {
        return inputs
            .filterIndexed { index, _ -> index % down == 0 }
            .filterIndexed { index, input ->
                val pos = (index * right) % input.count()
                input[pos] == '#'
            }.count()

    }
}
