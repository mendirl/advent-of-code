package io.mendirl.adventofcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day8Test : DayTest(8) {

    @Test
    fun `test part 1`() {
        val result = Day8().step1(inputs)

        Assertions.assertEquals(1816, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day8().step2(inputs)

        Assertions.assertEquals(1149, result)
    }

}
