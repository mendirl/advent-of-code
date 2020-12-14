package io.mendirl.adventofcode

import com.google.common.collect.Sets

class Day9 : Day() {
    override fun step1(inputs: List<String>): Int {
        return compute1(inputs, 25).toInt()
    }

    fun compute1(inputs: List<String>, preamble: Int): Long {
        val series = inputs.map { it.toLong() }

        val indice = (preamble..series.size).first { i ->
            Sets.combinations(series.slice(i - preamble..i).toSet(), 2)
                .none {
                    it.sum() == series[i]
                }
        }

        return series[indice]
    }

    override fun step2(inputs: List<String>): Int {
        return compute2(inputs, 25).toInt()
    }

    fun compute2(inputs: List<String>, preamble: Int): Long {
        val target = compute1(inputs, preamble)
        val series = inputs.map { it.toLong() }

        series.indices.forEach { i ->
            for (j in i + 2 until series.size) {
                val slices = series.slice(i..j)
                if (slices.sum() == target) {
                    return slices.maxOrNull()!! + slices.minOrNull()!!
                }
            }
        }
        return -1
    }

}
