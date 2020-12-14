package io.mendirl.adventofcode

import com.google.common.collect.Sets

class Day1 : Day {

    override fun step1(inputs: List<String>) = calcul(HashSet(inputs.toInt()), 2)

    override fun step2(inputs: List<String>) = calcul(HashSet(inputs.toInt()), 3)

    private fun calcul(inputs: Set<Int>, size: Int): Int {
        return inputs.combinations(size)
            .filter { it.sum() == 2020 }
            .map { it.reduce { x, y -> x * y } }
            .first()
    }
}

fun <T> Set<T>.combinations(size: Int): Set<Set<T>> {
    return Sets.combinations(this, size)
}
