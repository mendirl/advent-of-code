package io.mendirl.adventofcode

abstract class Day {

    abstract fun step1(inputs: List<String>): Int
    abstract fun step2(inputs: List<String>): Int

    fun List<String>.toInt(): List<Int> = this.map { it.toInt() }

    fun List<String>.toInt(radix: Int) = this.map { it.toInt(2) }

}
