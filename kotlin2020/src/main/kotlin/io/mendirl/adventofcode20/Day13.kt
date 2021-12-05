package io.mendirl.adventofcode20

class Day13 : Day {

    override fun step1(inputs: List<String>): Int {
        val timestamp = inputs[0].toInt()
        val buses = inputs[1].split(",").filterNot { it == "x" }.toInt()

        val bus = buses.map { bus ->
            generateSequence(bus) {
                it + bus
            }.first {
                it > timestamp
            } to bus

        }.minByOrNull { it.first }

        return (bus!!.first - timestamp) * bus!!.second
    }


    override fun step2(inputs: List<String>): Long {
        return inputs[1].split(",")
            .withIndex()
            .filterNot { it.value == "x" }
//            .map { it.value.toInt() to it.index }
            .map { it.value.toInt() to (it.value.toInt() - it.index) }
            .let { chineseRemainder(it) }
    }

    private fun chineseRemainder(pairs: List<Pair<Int, Int>>): Long {
        val pairsAsBig = pairs.map { it.first.toBigInteger() to it.second.toBigInteger() }
        val prod = pairsAsBig
            .fold(1.toBigInteger()) { acc, i -> acc * i.first }
        var sum = 0.toBigInteger()

        for ((ni, ai) in pairsAsBig) {
            val p = prod / ni
            val modInverse = p.modInverse(ni)
            sum += ai * modInverse * p
        }

        return (sum % prod).toLong()
    }

}
