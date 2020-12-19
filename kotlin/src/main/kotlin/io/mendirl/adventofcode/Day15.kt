package io.mendirl.adventofcode

class Day15 : Day {

    override fun step1(inputs: List<String>): Int {
        return turn(inputs[0].split(",").toInt(), 2020)
    }


    override fun step2(inputs: List<String>): Int {
        return turn(inputs[0].split(",").toInt(), 30000000)
    }

    fun turn(inputs: List<Int>, turn: Int): Int {
        val spoken = inputs.mapIndexed { i, n -> n to mutableListOf(i + 1) }.toMap().toMutableMap()
        var number = if (inputs.size >= turn) inputs[turn - 1] else 0

        (inputs.size + 1 until turn + 1).forEach {
            if (spoken.containsKey(number)) {
                var lastspokens = spoken[number]
                val size = lastspokens!!.size

                number = if (size == 1) 0 else lastspokens[size - 1] - lastspokens[size - 2]

                lastspokens = spoken.getOrPut(number) { mutableListOf() }
                lastspokens.add(it)
            } else {
                number = it
                spoken[number] = mutableListOf(it)
            }
        }

        return number
    }

}
