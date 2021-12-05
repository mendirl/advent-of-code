package io.mendirl.adventofcode20

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day5Test : DayTest(5) {

    @Test
    fun `test part 1`() {
        val result = Day5().step1(inputs)

        Assertions.assertEquals(980, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day5().step2(inputs)

        Assertions.assertEquals(607, result)
    }

}
