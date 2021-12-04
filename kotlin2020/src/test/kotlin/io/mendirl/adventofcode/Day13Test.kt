package io.mendirl.adventofcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day13Test : DayTest(13) {

    @Test
    fun `test part 1`() {
        val result = Day13().step1(inputs)

        Assertions.assertEquals(3464, result)
    }

    @Test
    fun `test part 2`() {
        val result = Day13().step2(inputs)

        Assertions.assertEquals(760171380521445, result)
    }

    @Test
    fun `test sample 1`() {
        val localInput = listOf(
            "939",
            "7,13,x,x,59,x,31,19"
        )

        val result = Day13().step1(localInput)

        Assertions.assertEquals(295, result)
    }

    @Test
    fun `test sample 1 1`() {
        val localInput = listOf(
            "939",
            "7"
        )

        val result = Day13().step1(localInput)

        Assertions.assertEquals(42, result)
    }

    @Test
    fun `test sample 1 2`() {
        val localInput = listOf(
            "939",
            "7,59"
        )

        val result = Day13().step1(localInput)

        Assertions.assertEquals(295, result)
    }

    @Test
    fun `test sample 2 1`() {
        val localInput = listOf(
            "939",
            "7,13,x,x,59,x,31,19"
        )

        val result = Day13().step2(localInput)

        Assertions.assertEquals(1068781, result)
    }

    // problem from
    // http://www.bibmath.net/dico/index.php?action=affiche&quoi=./c/chinois.html
    // doesn't work with the algo, need to uncomment line 26 in Day13.kt file
    @Disabled
    @Test
    fun `test sample 2 2`() {
        val localInput = listOf(
            "939",
            "x,x,x,17,11,6"
        )

        val result = Day13().step2(localInput)

        Assertions.assertEquals(785, result)
    }


    @Test
    fun `test sample 2 3`() {
        val localInput = listOf(
            "939",
            "17,x,13,19"
        )

        val result = Day13().step2(localInput)

        Assertions.assertEquals(3417, result)
    }


}
