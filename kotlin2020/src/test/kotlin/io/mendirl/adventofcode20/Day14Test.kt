package io.mendirl.adventofcode20

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day14Test : DayTest(14) {

    @Test
    fun `test part 1`() {
        val result = Day14().step1(inputs)

        Assertions.assertThat(result).isEqualTo(17765746710228)
    }

    @Test
    fun `test part 2`() {
        val result = Day14().step2(inputs)

        Assertions.assertThat(result).isEqualTo(4401465949086)
    }

    @Test
    fun `test sample 1`() {
        val localInput = listOf(
            "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
            "mem[8] = 11",
            "mem[7] = 101",
            "mem[8] = 0"
        )

        val result = Day14().step1(localInput)

        Assertions.assertThat(result).isEqualTo(165)
    }

    @Test
    fun `test convert int to binary`() {
        val result = "11".to36Bits()
        Assertions.assertThat(result).isEqualTo("000000000000000000000000000000001011")
    }

    @Test
    fun `test convert binary to int`() {
        val result = "000000000000000000000000000000001011".from36Bits()
        Assertions.assertThat(result).isEqualTo(11L)
    }

    @Test
    fun `test apply mask`() {
        val result = Day14().mask("000000000000000000000000000000001011", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X")

        Assertions.assertThat(result).isEqualTo("000000000000000000000000000001001001")
    }

    @Test
    fun `test apply memory mask`() {
        val result = Day14().maskMemory("42".to36Bits(), "000000000000000000000000000000X1001X")

        Assertions.assertThat(result).isEqualTo("000000000000000000000000000000X1101X")
    }

    @Test
    fun `test generation permutation`() {
        val result = Day14().permutation("000000000000000000000000000000X1101X")

        val expected = listOf(
            "000000000000000000000000000000011010",
            "000000000000000000000000000000011011",
            "000000000000000000000000000000111010",
            "000000000000000000000000000000111011"
        )

        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected)
    }

}
