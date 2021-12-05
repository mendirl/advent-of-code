package io.mendirl.adventofcode20

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day11Test : DayTest(11) {

    @Test
    fun `test part 1`() {
        val result = Day11().step1(inputs)

        Assertions.assertEquals(2470, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day11().step2(inputs)

        Assertions.assertEquals(2259, result)
    }

}
