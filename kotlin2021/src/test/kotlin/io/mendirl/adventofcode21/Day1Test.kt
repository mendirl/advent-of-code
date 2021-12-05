package io.mendirl.adventofcode21

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Test : DayTest(1) {


    @Test
    fun `sample part 1`() {
        val input = listOf("199", "200", "208", "210", "200", "207", "240", "269", "260", "263")

        val result = Day1().step1(input)

        Assertions.assertEquals(7, result)
    }


    @Test
    fun `test part 1`() {
        val result = Day1().step1(inputs)

        Assertions.assertEquals(1298, result)
    }


    @Test
    fun `sample part 2`() {
        val input = listOf("199", "200", "208", "210", "200", "207", "240", "269", "260", "263")

        val result = Day1().step2(input)

        Assertions.assertEquals(5, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day1().step2(inputs)

        Assertions.assertEquals(1248, result)
    }

}
