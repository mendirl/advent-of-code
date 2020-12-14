package io.mendirl.adventofcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day9Test : DayTest(9) {

    @Test
    fun `test part 1`() {
        val result = Day9().step1(inputs)

        Assertions.assertEquals(138879426, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day9().step2(inputs)

        Assertions.assertEquals(23761694, result)
    }

    @Test
    fun `test sample 1`() {
        val localInput = listOf(
            "35",
            "20",
            "15",
            "25",
            "47",
            "40",
            "62",
            "55",
            "65",
            "95",
            "102",
            "117",
            "150",
            "182",
            "127",
            "219",
            "299",
            "277",
            "309",
            "576"
        )

        val result = Day9().compute1(localInput, 5)

        Assertions.assertEquals(127, result)
    }


    @Test
    fun `test sample 2`() {
        val localInput = listOf(
            "35",
            "20",
            "15",
            "25",
            "47",
            "40",
            "62",
            "55",
            "65",
            "95",
            "102",
            "117",
            "150",
            "182",
            "127",
            "219",
            "299",
            "277",
            "309",
            "576"
        )

        val result = Day9().compute2(localInput, 5)

        Assertions.assertEquals(62, result)
    }

}
