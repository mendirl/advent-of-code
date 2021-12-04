package io.mendirl.adventofcode

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day15Test : DayTest(15) {

    @Test
    fun `test part 1`() {
        val result = Day15().step1(inputs)

        Assertions.assertThat(result).isEqualTo(1025)
    }

    @Test
    fun `test part 2`() {
        val result = Day15().step2(inputs)

        Assertions.assertThat(result).isEqualTo(129262)
    }

    @Test
    fun `test turn 1`() {
        val localInput = listOf(0, 3, 6)

        val result = Day15().turn(localInput, 1)

        Assertions.assertThat(result).isEqualTo(0)
    }

    @Test
    fun `test turn 2`() {
        val localInput = listOf(0, 3, 6)

        val result = Day15().turn(localInput, 2)

        Assertions.assertThat(result).isEqualTo(3)
    }

    @Test
    fun `test turn 3`() {
        val localInput = listOf(0, 3, 6)

        val result = Day15().turn(localInput, 3)

        Assertions.assertThat(result).isEqualTo(6)
    }

    @Test
    fun `test turn 4`() {
        val localInput = listOf(0, 3, 6)

        val result = Day15().turn(localInput, 4)

        Assertions.assertThat(result).isEqualTo(0)
    }

    @Test
    fun `test turn 5`() {
        val localInput = listOf(0, 3, 6)

        val result = Day15().turn(localInput, 5)

        Assertions.assertThat(result).isEqualTo(3)
    }

    @Test
    fun `test turn 6`() {
        val localInput = listOf(0, 3, 6)

        val result = Day15().turn(localInput, 6)

        Assertions.assertThat(result).isEqualTo(3)
    }

    @Test
    fun `test turn 7`() {
        val localInput = listOf(0, 3, 6)

        val result = Day15().turn(localInput, 7)

        Assertions.assertThat(result).isEqualTo(1)
    }

    @Test
    fun `test turn 8`() {
        val localInput = listOf(0, 3, 6)

        val result = Day15().turn(localInput, 8)

        Assertions.assertThat(result).isEqualTo(0)
    }

    @Test
    fun `test turn 9`() {
        val localInput = listOf(0, 3, 6)

        val result = Day15().turn(localInput, 9)

        Assertions.assertThat(result).isEqualTo(4)
    }

    @Test
    fun `test turn 10`() {
        val localInput = listOf(0, 3, 6)

        val result = Day15().turn(localInput, 10)

        Assertions.assertThat(result).isEqualTo(0)
    }
}
