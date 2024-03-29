package io.mendirl.adventofcode20

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day7Test : DayTest(7) {

    @Test
    fun `test part 1`() {
        val result = Day7().step1(inputs)

        Assertions.assertEquals(261, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day7().step2(inputs)

        Assertions.assertEquals(3765, result)
    }

    @Test
    fun `test sample 1`() {
        val localInput = listOf(
            "light red bags contain 1 bright white bag, 2 muted yellow bags.",
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
            "bright white bags contain 1 shiny gold bag.",
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
            "faded blue bags contain no other bags.",
            "dotted black bags contain no other bags."
        )

        val result = Day7().step1(localInput)

        Assertions.assertEquals(4, result)
    }

    @Test
    fun `test sample 2`() {
        val localInput = listOf(
            "shiny gold bags contain 2 dark red bags.",
            "dark red bags contain 2 dark orange bags.",
            "dark orange bags contain 2 dark yellow bags.",
            "dark yellow bags contain 2 dark green bags.",
            "dark green bags contain 2 dark blue bags.",
            "dark blue bags contain 2 dark violet bags.",
            "dark violet bags contain no other bags."
        )

        val result = Day7().step2(localInput)

        Assertions.assertEquals(126, result)
    }
}
