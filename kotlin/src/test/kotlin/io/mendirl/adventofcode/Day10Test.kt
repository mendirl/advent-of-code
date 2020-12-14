package io.mendirl.adventofcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day10Test : DayTest(10) {

    @Test
    fun `test part 1`() {
        val result = Day10().step1(inputs)

        Assertions.assertEquals(2263, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day10().step2(inputs)

        Assertions.assertEquals(396857386627072, result)
    }

    @Test
    fun `test sample 1`() {
        val localInput = listOf(
            "16",
            "10",
            "15",
            "5",
            "1",
            "11",
            "7",
            "19",
            "6",
            "12",
            "4"
        )

        val result = Day10().step1(localInput)

        Assertions.assertEquals(35, result)
    }

    @Test
    fun `test sample 1 1`() {
        val localInput = listOf(
            "28",
            "33",
            "18",
            "42",
            "31",
            "14",
            "46",
            "20",
            "48",
            "47",
            "24",
            "23",
            "49",
            "45",
            "19",
            "38",
            "39",
            "11",
            "1",
            "32",
            "25",
            "35",
            "8",
            "17",
            "7",
            "9",
            "4",
            "2",
            "34",
            "10",
            "3"
        )

        val result = Day10().step1(localInput)

        Assertions.assertEquals(220, result)
    }

    @Test
    fun `test sample 2`() {
        val localInput = listOf(
            "16",
            "10",
            "15",
            "5",
            "1",
            "11",
            "7",
            "19",
            "6",
            "12",
            "4"
        )

        val result = Day10().step2(localInput)

        Assertions.assertEquals(8, result)
    }

    @Test
    fun `test sample 2 2`() {
        val localInput = listOf(
            "28",
            "33",
            "18",
            "42",
            "31",
            "14",
            "46",
            "20",
            "48",
            "47",
            "24",
            "23",
            "49",
            "45",
            "19",
            "38",
            "39",
            "11",
            "1",
            "32",
            "25",
            "35",
            "8",
            "17",
            "7",
            "9",
            "4",
            "2",
            "34",
            "10",
            "3"
        )

        val result = Day10().step2(localInput)

        Assertions.assertEquals(19208, result)
    }

}
