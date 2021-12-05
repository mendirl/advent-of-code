package io.mendirl.adventofcode21

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day4Test : DayTest(3) {


    @Test
    fun `sample part 1`() {
        val input = listOf(
            "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",

            "22 13 17 11  0",
            " 8  2 23  4 24",
            "21  9 14 16  7",
            " 6 10  3 18  5",
            " 1 12 20 15 19",

            " 3 15  0  2 22",
            " 9 18 13 17  5",
            "19  8  7 25 23",
            "20 11 10 24  4",
            "14 21 16 12  6",

            "14 21 17 24  4",
            "10 16 15  9 19",
            "18  8 23 26 20",
            "22 11 13  6  5",
            " 2  0 12  3  7",
        )

        val result = Day4().step1(input)

        Assertions.assertEquals(198, result)
    }

    @Test
    fun `test part 1`() {
        val result = Day4().step1(inputs)

        Assertions.assertEquals(3959450, result)
    }


    @Test
    fun `sample part 2`() {
        val input = listOf(
            "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
            "",
            "22 13 17 11  0",
            " 8  2 23  4 24",
            "21  9 14 16  7",
            " 6 10  3 18  5",
            " 1 12 20 15 19",
            "",
            " 3 15  0  2 22",
            " 9 18 13 17  5",
            "19  8  7 25 23",
            "20 11 10 24  4",
            "14 21 16 12  6",
            "",
            "14 21 17 24  4",
            "10 16 15  9 19",
            "18  8 23 26 20",
            "22 11 13  6  5",
            " 2  0 12  3  7",
        )

        val result = Day4().step2(input)

        Assertions.assertEquals(230, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day4().step2(inputs)

        Assertions.assertEquals(7440311, result)
    }

}
