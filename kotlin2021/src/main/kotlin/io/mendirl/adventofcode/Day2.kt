package io.mendirl.adventofcode

class Day2 : Day {

    override fun step1(inputs: List<String>): Int {
        var depth = 0
        var pos = 0

        inputs.flatMap {
            it.split(" ")
        }.windowed(2) {
            when (it[0]) {
                "forward" -> pos += it[1].toInt()
                "down" -> depth += it[1].toInt()
                "up" -> depth -= it[1].toInt()
                else -> 0
            }
        }

        return depth * pos
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
