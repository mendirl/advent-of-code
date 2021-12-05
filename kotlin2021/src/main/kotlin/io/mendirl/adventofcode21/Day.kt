package io.mendirl.adventofcode21

interface Day {

    fun step1(inputs: List<String>): Any?
    fun step2(inputs: List<String>): Any?

    fun List<String>.toInt(): List<Int> = this.map { it.toInt() }
    fun List<String>.toLong(): List<Long> = this.map { it.toLong() }

    fun List<String>.toInt(radix: Int) = this.map { it.toInt(radix) }

}
