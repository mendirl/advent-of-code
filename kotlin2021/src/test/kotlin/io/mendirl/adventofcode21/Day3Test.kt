package io.mendirl.adventofcode21

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day3Test : DayTest(3) {


    @Test
    fun `sample part 1`() {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )

        val result = Day3().step1(input)

        Assertions.assertEquals(198, result)
    }

    @Test
    fun `test part 1`() {
        val result = Day3().step1(inputs)

        Assertions.assertEquals(3959450, result)
    }


    @Test
    fun `sample part 2`() {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )

        val result = Day3().step2(input)

        Assertions.assertEquals(230, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day3().step2(inputs)

        Assertions.assertEquals(7440311, result)
    }

}
