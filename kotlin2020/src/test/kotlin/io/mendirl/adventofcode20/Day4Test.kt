package io.mendirl.adventofcode20

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day4Test : DayTest(4) {

    @Test
    fun `test part 1`() {
        val result = Day4().step1(inputs)

        Assertions.assertEquals(228, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day4().step2(inputs)

        Assertions.assertEquals(175, result)
    }

}
