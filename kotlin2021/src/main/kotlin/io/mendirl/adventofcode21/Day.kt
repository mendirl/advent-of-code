package io.mendirl.adventofcode21

interface Day {

    fun step1(inputs: List<String>): Number
    fun step2(inputs: List<String>): Number

    fun List<String>.toInt(): List<Int> = this.map { it.toInt() }
    fun List<String>.toLong(): List<Long> = this.map { it.toLong() }

    fun List<String>.toInt(radix: Int) = this.map { it.toInt(radix) }

    fun Int.toDecimal(): Int {
        var intemediaire = this
        var decimalNumber = 0
        var i = 0
        var remainder: Int

        while (intemediaire.toInt() != 0) {
            remainder = intemediaire % 10
            intemediaire /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }

}
