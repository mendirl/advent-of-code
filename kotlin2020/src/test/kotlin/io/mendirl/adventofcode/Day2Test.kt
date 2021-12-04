package io.mendirl.adventofcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day2Test : DayTest(2) {

    @Test
    fun `test part 1`() {
        val result = Day2().step1(inputs)

        Assertions.assertEquals(580, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day2().step2(inputs)

        Assertions.assertEquals(611, result)
    }

}
