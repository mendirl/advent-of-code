package io.mendirl.adventofcode

interface Day {

    fun step1(inputs: List<String>): Number
    fun step2(inputs: List<String>): Number

    fun List<String>.toInt(): List<Int> = this.map { it.toInt() }
    fun List<String>.toLong(): List<Long> = this.map { it.toLong() }

    fun List<String>.toInt(radix: Int) = this.map { it.toInt(radix) }

}
