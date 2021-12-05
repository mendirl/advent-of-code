package io.mendirl.adventofcode20

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day6Test : DayTest(6) {

    @Test
    fun `test part 1`() {
        val result = Day6().step1(inputs)

        Assertions.assertEquals(6596, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day6().step2(inputs)

        Assertions.assertEquals(3219, result)
    }

}
