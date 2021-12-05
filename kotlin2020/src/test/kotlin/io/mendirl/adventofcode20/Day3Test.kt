package io.mendirl.adventofcode20

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day3Test : DayTest(3) {

    @Test
    fun `test part 1`() {
        val result = Day3().step1(inputs)

        Assertions.assertEquals(148, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day3().step2(inputs)

        Assertions.assertEquals(727923200, result)
    }

}
