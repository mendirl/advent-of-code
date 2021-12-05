package io.mendirl.adventofcode21

import kotlin.math.abs

class Day3 : Day {

    override fun step1(inputs: List<String>): Int {
        val result = arrayOfNulls<Int>(inputs[0].length)

        inputs.map {
            it.forEachIndexed { index, c ->
                if (result[index] == null) {
                    result[index] = c.digitToInt()
                } else {
                    result[index] = result[index]?.plus(c.digitToInt())
                }
            }
        }

        val gamma = gamma(result, inputs.size)
        val epsilon = epsilon(result, inputs.size)

        return gamma * epsilon
    }


    private fun gamma(result: Array<Int?>, size: Int): Int {
        return result.map {
            if (it!! < size - it) "1" else "0"
        }.reduce { acc, i ->
            acc + i
        }.toInt(2)
    }

    private fun epsilon(result: Array<Int?>, size: Int): Int {
        return result.map {
            if (it!! > size - it) "1" else "0"
        }.reduce { acc, i ->
            acc + i
        }.toInt(2)
    }

    override fun step2(inputs: List<String>): Int {
        val o2 = o2(inputs)
        val co2 = co2(inputs)

        return o2 * co2
    }

    private fun o2(result: List<String>): Int {
        var inter = result
        var pos = 0
        do {
            inter = fil(inter, pos++, 1) { i, i2 -> i >= i2 }!!
        } while (inter.size > 1)

        return inter[0].toInt(2)
    }


    private fun co2(result: List<String>): Int {
        var inter = result
        var pos = 0
        do {
            inter = fil(inter, pos++, 0) { i, i2 -> i <= i2 }!!
        } while (inter.size > 1)

        return inter[0].toInt(2)
    }

    private fun fil(input: List<String>, pos: Int, number: Int, comp: (Int, Int) -> Boolean): List<String>? {
        return input.groupBy {
            if (it[pos].toString() == number.toString()) number else abs(number + 1)
        }.let {
            if (comp(it[number]!!.size, it[abs(number + 1)]!!.size)) it[number] else it[abs(number + 1)]
        }
    }

}
