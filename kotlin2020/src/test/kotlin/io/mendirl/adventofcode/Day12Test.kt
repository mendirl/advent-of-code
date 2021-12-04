package io.mendirl.adventofcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day12Test : DayTest(12) {

    @Test
    fun `test part 1`() {
        val result = Day12().step1(inputs)

        Assertions.assertEquals(582, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day12().step2(inputs)

        Assertions.assertEquals(52069, result)
    }

    @Test
    fun `test sample 1`() {
        val localInput = listOf(
            "F10",
            "N3",
            "F7",
            "R90",
            "F11"
        )

        val result = Day12().step1(localInput)

        Assertions.assertEquals(25, result)
    }

    @Test
    fun `test sample 2`() {
        val localInput = listOf(
            "F10",
            "N3",
            "F7",
            "R90",
            "F11"
        )

        val result = Day12().step2(localInput)

        Assertions.assertEquals(286, result)
    }
}
