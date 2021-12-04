package io.mendirl.adventofcode

class Day7 : Day {
    override fun step1(inputs: List<String>): Int {
        val myBag = "shiny gold"
        val outerBags = mutableSetOf<String>()
        val bagQueue = ArrayDeque<String>()
        bagQueue.add(myBag)


        while (bagQueue.isNotEmpty()) {
            val innerBag = bagQueue.removeLast()
            inputs.content().filterValues { bags ->
                bags.any { it.second == innerBag }
            }.keys.forEach { bag ->
                if (outerBags.add(bag))
                    bagQueue.add(bag)
            }
        }

        return outerBags.size;

    }

    override fun step2(inputs: List<String>): Int {
        val myBag = "shiny gold"

        fun contains(bag: String): Int =
            inputs.content()[bag]!!.sumBy { (n, color) -> n + (n * contains(color)) }

        return contains(myBag)
    }

}

fun List<String>.content(): Map<String, List<Pair<Int, String>>> {
    return this.associate { line ->
        val (bag, contains) = line.split(" bags contain ")
        val contentList = contains.split(", ")
            .mapNotNull { s ->
                val (n, adj, color) = s.split(' ')
                n.toIntOrNull()?.let { it to "$adj $color" }
            }
        bag to contentList
    }

}


