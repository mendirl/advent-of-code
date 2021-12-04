package io.mendirl.adventofcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day2Test : DayTest(2) {


    @Test
    fun `sample part 1`() {
        val input = listOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")

        val result = Day2().step1(input)

        Assertions.assertEquals(150, result)
    }

    @Test
    fun `test part 1`() {
        val result = Day2().step1(inputs)

        Assertions.assertEquals(1924923, result)
    }


    @Test
    fun `sample part 2`() {
        val input = listOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")

        val result = Day2().step2(input)

        Assertions.assertEquals(900, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day2().step2(inputs)

        Assertions.assertEquals(1982495697, result)
    }

}
