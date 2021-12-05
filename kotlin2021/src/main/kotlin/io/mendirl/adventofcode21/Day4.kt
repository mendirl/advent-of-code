package io.mendirl.adventofcode21

import java.util.stream.IntStream.range
import kotlin.math.abs
import kotlin.math.log

class Day4 : Day {

    override fun step1(inputs: List<String>): Int {

        val drawNumbers = inputs.first().split(',').toInt()
        println("numbers to draw : $drawNumbers")

        val boards = inputs.drop(1)
            .flatMap {
                "\\d+".toRegex().findAll(it)
                    .map { it.value.toInt() }
                    .chunked(5).toList()
            }
            .chunked(5) as Boards


        (1..drawNumbers.size).forEach {
            drawNumbers.subList(0, it).let { numbers ->
                boards.wins(numbers)
            }

        }


        return 0
    }

    override fun step2(inputs: List<String>): Int {
        return 0
    }

}

typealias Boards = List<List<List<Int>>>

private fun Boards.wins(numbers: List<Int>): Boolean {
    return this.any {
        it.any {
            it.intersect(numbers).size == 5
        }
    }
}



