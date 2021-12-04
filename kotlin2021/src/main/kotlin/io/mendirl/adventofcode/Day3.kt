package io.mendirl.adventofcode

class Day3 : Day {

    override fun step1(inputs: List<String>): Int {

        val result = arrayOfNulls<Int?>(inputs[0].length)


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
        result.map {
            return if (it!! > size - it) {
                "1"
            } else {
                "O"
            }
        }.map {

        }

        return 0
    }

    private fun epsilon(result: Array<Int?>, size: Int): Int {
        return 0
    }

    override fun step2(inputs: List<String>): Int {
        var depth = 0
        var pos = 0
        var aim = 0

        inputs.flatMap {
            it.split(" ")
        }.windowed(2) {
            when (it[0]) {
                "forward" -> {
                    pos += it[1].toInt()
                    depth += it[1].toInt() * aim
                }
                "down" -> {
                    aim += it[1].toInt()
                }
                "up" -> {
                    aim -= it[1].toInt()
                }
                else -> 0
            }
        }

        return depth * pos
    }

    private fun calcul(inputs: List<String>): Int {
        var depth = 0
        var pos = 0
        var aim = 0

        inputs.flatMap {
            it.split(" ")
        }.windowed(2) {
            when (it[0]) {
                "forward" -> {
                    pos += it[1].toInt()
                    depth += it[1].toInt() * aim
                }
                "down" -> {
                    aim += it[1].toInt()
                }
                "up" -> {
                    aim -= it[1].toInt()
                }
                else -> 0
            }
        }

        return depth * pos
    }
}
