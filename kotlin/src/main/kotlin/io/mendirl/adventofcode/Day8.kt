package io.mendirl.adventofcode

class Day8 : Day() {
    var acc = 0

    override fun step1(inputs: List<String>): Int {
        val computer = Computer(inputs, 0)
        computer.execute()
        return computer.acc
    }

    override fun step2(inputs: List<String>): Int {
     return inputs.indices.map {
            val s = inputs[it]
            val replaced = when {
                s.contains("jmp") -> s.replace("jmp", "nop")
                s.contains("nop") -> s.replace("nop", "jmp")
                else -> s
            }
            val arrayList = ArrayList<String>(inputs)
            arrayList.removeAt(it)
            arrayList.add(it, replaced)

            Computer(arrayList, 0)
        }.first { it.execute() }.acc
    }


}

data class Computer(val inputs: List<String>, var acc: Int) {
    fun execute(): Boolean {
        var pos = 0
        val computed = HashSet<Int>()

        while (pos < inputs.size) {
            val (action, value) = inputs[pos].split(" ")
            if (!computed.add(pos)) return false
            when (action) {
                "nop" -> pos++
                "acc" -> {
                    pos++; acc += value.toInt()
                }
                "jmp" -> {
                    pos += value.toInt()
                }
            }
        }
        return true
    }
}
