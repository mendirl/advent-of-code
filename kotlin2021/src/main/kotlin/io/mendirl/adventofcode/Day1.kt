package io.mendirl.adventofcode

class Day1 : Day {

    override fun step1(inputs: List<String>) =
        calcul(inputs.toInt(), 1)

    override fun step2(inputs: List<String>) =
        calcul(inputs.toInt(), 3)

    private fun calcul(inputs: List<Int>, windowSize: Int) =
        inputs.windowed(windowSize).map { it.sum() }
            .windowed(2).count {
                it[0] < it[1]
            }
}
