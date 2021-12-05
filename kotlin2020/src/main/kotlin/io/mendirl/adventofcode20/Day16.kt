package io.mendirl.adventofcode20

class Day16 : Day {

    override fun step1(inputs: List<String>): Int {
        val parsing = parse(inputs)

        return validate(parsing.first, parsing.second)
    }

    override fun step2(inputs: List<String>): Long {
        val parsing = parse(inputs)

        val validTickets = exclude(parsing.first, parsing.second)

        val grouping = groupAllTickets(parsing.first, validTickets)

        val reduced = reduceRulesGroup(grouping)

        val reduceFinal = reduceFinal(reduced, arrayOfNulls(reduced.size))

        return reduceFinal.mapIndexed { index, s ->
            if (s!!.startsWith("departure"))
                parsing.third[index].toLong()
            else 1L
        }.reduce(Long::times)
    }

    fun parse(inputs: List<String>): Triple<Map<String, List<IntRange>>, List<List<Int>>, List<Int>> {
        val regex = Regex("([a-z ]+): (\\d+)-(\\d+) or (\\d+)-(\\d+)")
        val rules = mutableMapOf<String, List<IntRange>>()
        val tickets = mutableListOf<List<Int>>()

        inputs.forEach {
            if ("or" in it) {
                val (name, l1, u1, l2, u2) = regex.find(it)!!.destructured
                rules[name] = listOf(IntRange(l1.toInt(), u1.toInt()), IntRange(l2.toInt(), u2.toInt()))
            } else if ("," in it) {
                tickets.add(it.split(",").toInt())
            }
        }

        return Triple(rules, tickets.drop(1), tickets[0])
    }

    fun validate(rules: Map<String, List<IntRange>>, tickets: List<List<Int>>) = tickets.sumBy {
        it.filter { ticket ->
            rules.values.flatten().none { rule -> ticket in rule }
        }.sum()
    }

    fun validatTicket(rules: Map<String, List<IntRange>>, ticket: List<Int>) =
        ticket.all { value -> rules.any { rule -> value in rule.value.flatten() } }


    fun exclude(rules: Map<String, List<IntRange>>, tickets: List<List<Int>>) = tickets.filter { ticket ->
        validatTicket(rules, ticket)
    }

    fun groupOneTicket(rules: Map<String, List<IntRange>>, ticket: List<Int>) = ticket.map { field ->
        rules.filter { rule -> field in rule.value.flatten() }
            .map { it.key }
    }

    fun groupAllTickets(rules: Map<String, List<IntRange>>, tickets: List<List<Int>>) = tickets.map {
        Day16().groupOneTicket(rules, it)
    }

    fun reduceRulesGroup(groups: List<List<List<String>>>) = groups.reduce { acc, list ->
        acc.zip(list) { a, b ->
            a.filter { it in b }
        }.toMutableList()
    } as List<MutableList<String>>

    fun reduceFinal(groups: List<MutableList<String>>, acc: Array<String?>): List<String?> {
        if (acc.all { it != null }) return acc.toList()

        val firstIdx = groups.indexOfFirst { it.size == 1 }
        val elementToRemove = groups[firstIdx][0]
        acc[firstIdx] = elementToRemove

        groups.forEach { list -> list.remove(elementToRemove) }

        return reduceFinal(groups, acc)
    }
}
