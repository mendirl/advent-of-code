package io.mendirl.adventofcode20

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Test : DayTest(1) {

    @Test
    fun `test part 1`() {
        val result = Day1().step1(inputs)

        Assertions.assertEquals(444019, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day1().step2(inputs)

        Assertions.assertEquals(29212176, result)
    }

}
