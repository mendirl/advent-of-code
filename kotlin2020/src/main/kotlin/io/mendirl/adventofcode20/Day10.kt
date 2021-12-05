package io.mendirl.adventofcode20

import kotlin.math.pow

class Day10 : Day {
    override fun step1(inputs: List<String>): Int {
        return inputs.groups()
            .groupingBy { it }.eachCount()
            .values
//            .reduce { x, y -> y * x }
            .reduce(Int::times)
    }

    override fun step2(inputs: List<String>): Long {
        var acc = 0

        return inputs.groups()
            .map {
                if (it == 1) {
                    0.also { acc++ }
                } else {
                    acc.also { acc = 0 }
                }
            }.filter { it > 1 }
            .map {
                when (it) {
                    4 -> 7L
                    3 -> 4L
                    2 -> 2L
                    else -> 1L
                }
            }.reduce(Long::times)

//        return inputs.groups()
//            .map {
//                if (it == 1) {
//                    0.also { acc++ }
//                } else {
//                    acc.also { acc = 0 }
//                }
//            }.filter { it > 1 }
//            .groupingBy { it }.eachCount().entries.map {
//                when (it.key) {
//                    4 -> 7.0.pow(it.value.toDouble())
//                    3 -> 4.0.pow(it.value.toDouble())
//                    2 -> 2.0.pow(it.value.toDouble())
//                    else -> 1
//                }
//            }
//            .map { it.toLong() }
//            .reduce(Long::times)
    }

    private fun List<String>.groups(): List<Int> =
        this.toInt().toMutableSet().apply {
            this.add(0)
            this.add(this.maxOrNull()!! + 3)
        }.sorted()
//            .windowed(2, 1) { it.reduce { x, y -> y - x } }
            .zipWithNext { x, y -> y - x }
}
