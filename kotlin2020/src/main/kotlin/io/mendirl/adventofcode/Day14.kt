package io.mendirl.adventofcode

class Day14 : Day {

    override fun step1(inputs: List<String>): Long {
        var mask = ""
        val memory = hashMapOf<String, Long>()

        inputs.forEach {
            when {
                it.startsWith("mask") -> mask = it.drop("mask = ".length)
                it.startsWith("mem") -> {
                    val regex = Regex("mem\\[(\\d+)\\] = (\\d+)")
                    val (address, value) = regex.find(it)!!.destructured
                    memory[address] = mask(value.to36Bits(), mask).from36Bits()
                }
            }
        }

        return memory.values.sum()
    }


    override fun step2(inputs: List<String>): Long {
        var mask = ""
        var memory = hashMapOf<String, Long>()

        inputs.forEach {
            when {
                it.startsWith("mask") -> mask = it.drop("mask = ".length)
                it.startsWith("mem") -> {
                    val regex = Regex("mem\\[(\\d+)\\] = (\\d+)")
                    val (address, value) = regex.find(it)!!.destructured
                    val memoryMasked = maskMemory(address.to36Bits(), mask)
                    permutation(memoryMasked).forEach {
                        memory[it.from36Bits().toString()] = value.toLong()
                    }
                }
            }
        }

        return memory.values.sum()
    }

    fun maskMemory(memory: String, mask: String): String {
        return memory.zip(mask).map {
            when (it.second) {
                '0' -> it.first
                '1' -> '1'
                'X' -> 'X'
                else -> "not happening"
            }
        }.joinToString(separator = "") { it.toString() }
    }

    fun mask(value: String, mask: String): String {
        return value.zip(mask).map {
            when (it.second) {
                'X' -> it.first
                else -> it.second
            }
        }.joinToString(separator = "") { it.toString() }
    }

    fun permutation(memoryMasked: String): List<String> {
        val queue = ArrayDeque<String>()
        queue.addFirst(memoryMasked)

        val nb = memoryMasked.filter { it == 'X' }.count()

        val iteration = Math.pow(2.0, nb.toDouble())

        while (queue.size < iteration) {
            val removeLast = queue.removeLast()

            queue.addFirst(removeLast.replaceFirst("X", "0", true))
            queue.addFirst(removeLast.replaceFirst("X", "1", true))
        }

        return queue
    }

}

fun String.to36Bits() =
    this.toUInt().toString(2).padStart(36, '0')

fun String.from36Bits() =
    this.toLong(2)

