package io.mendirl.adventofcode20

class Day5 : Day {
    override fun step1(inputs: List<String>): Int {
        return calcul(inputs).maxOrNull()!!
    }

    override fun step2(inputs: List<String>): Int {
        return calcul(inputs).let { seats ->
            (1..128 * 8).first {
                !seats.contains(it) && seats.contains(it - 1) && seats.contains(it + 1)
            }
        }
    }

    private fun calcul(inputs: List<String>): List<Int> {
        return inputs.map {
            it
                .replace("F", "0")
                .replace("L", "0")
                .replace("B", "1")
                .replace("R", "1")
        }.toInt(2)
    }
}



