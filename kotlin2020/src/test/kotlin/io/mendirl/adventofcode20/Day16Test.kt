package io.mendirl.adventofcode20

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day16Test : DayTest(16) {

    companion object {
        private val classRange1 = listOf(IntRange(1, 3), IntRange(5, 7))
        private val rowRange1 = listOf(IntRange(6, 11), IntRange(33, 44))
        private val seatRange1 = listOf(IntRange(13, 40), IntRange(45, 50))
        private val rules1 = mapOf("class" to classRange1, "row" to rowRange1, "seat" to seatRange1)
        private val myticket1 = listOf(listOf(7, 1, 14))
        private val nearbyTickets1 = listOf(listOf(7, 3, 47), listOf(40, 4, 50), listOf(55, 2, 20), listOf(38, 6, 12))

        private val classRange2 = listOf(IntRange(0, 1), IntRange(4, 19))
        private val rowRange2 = listOf(IntRange(0, 5), IntRange(8, 19))
        private val seatRange2 = listOf(IntRange(0, 13), IntRange(16, 19))
        private val rules2 = mapOf("class" to classRange2, "row" to rowRange2, "seat" to seatRange2)
        private val myticket2 = listOf(listOf(11, 12, 13))
        private val nearbyTickets2 = listOf(listOf(3, 9, 18), listOf(15, 1, 5), listOf(5, 14, 9))
    }

    @Test
    fun `test part 1`() {
        val result = Day16().step1(inputs)

        assertThat(result).isEqualTo(19060)
    }

    @Test
    fun `test part 2`() {
        val result = Day16().step2(inputs)

        assertThat(result).isEqualTo(953713095011L)
    }

    @Test
    fun `test parsing 1`() {
        val inputs = listOf(
            "departure location: 32-209 or 234-963",
            "departure station: 47-64 or 83-967)",
            "",
            "your ticket:",
            "109,137,131,157,191,103,127,53,107,151,61,59,139,83,101,149,89,193,113,97",
            "",
            "nearby tickets:",
            "141,889,637,661,351,108,544,424,330,479,662,448,152,584,408,736,714,299,61,864",
            "692,855,843,361,21,265,678,716,347,531,56,792,492,656,727,848,149,596,887,862",
            "819,139,202,774,606,242,646,653,298,111,881,937,118,600,423,354,780,249,639,301"
        )
        val expected = Triple(
            mutableMapOf(
                "departure location" to listOf(
                    IntRange(32, 209), IntRange(234, 963)
                ),
                "departure station" to listOf(
                    IntRange(47, 64), IntRange(83, 967)
                )
            ), mutableListOf(
                listOf(
                    141, 889, 637, 661, 351, 108, 544, 424, 330, 479, 662, 448, 152, 584, 408, 736, 714, 299, 61, 864
                ),
                listOf(
                    692, 855, 843, 361, 21, 265, 678, 716, 347, 531, 56, 792, 492, 656, 727, 848, 149, 596, 887, 862
                ),
                listOf(
                    819, 139, 202, 774, 606, 242, 646, 653, 298, 111, 881, 937, 118, 600, 423, 354, 780, 249, 639, 301
                )
            ), listOf(109, 137, 131, 157, 191, 103, 127, 53, 107, 151, 61, 59, 139, 83, 101, 149, 89, 193, 113, 97)
        )

        val result = Day16().parse(inputs)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `test validate 1`() {
        val result = Day16().validate(rules1, listOf(nearbyTickets1[0]))

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `test validate 2`() {
        val result = Day16().validate(rules1, listOf(nearbyTickets1[1]))

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `test validate ticket true`() {
        val result = Day16().validatTicket(rules1, nearbyTickets1[0])

        assertThat(result).isTrue

    }

    @Test
    fun `test validate ticket false`() {
        val result = Day16().validatTicket(rules1, nearbyTickets1[1])

        assertThat(result).isFalse
    }

    @Test
    fun `test group ticket`() {
        val expected = listOf(
            listOf("row", "seat"), listOf("class", "row", "seat"), listOf("class", "row", "seat")
        )

        val validTickets = Day16().exclude(rules2, nearbyTickets2)

        val result = Day16().groupOneTicket(rules2, validTickets[0])

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `test group all tickets`() {
        val expected = listOf(
            listOf(listOf("row", "seat"), listOf("class", "row", "seat"), listOf("class", "row", "seat")),
            listOf(listOf("class", "row"), listOf("class", "row", "seat"), listOf("class", "row", "seat")),
            listOf(listOf("class", "row", "seat"), listOf("class", "row"), listOf("class", "row", "seat"))
        )
        val validTickets = Day16().exclude(rules2, nearbyTickets2)

        val result = Day16().groupAllTickets(rules2, validTickets)

        assertThat(result).isEqualTo(expected)
    }


    @Test
    fun `test reduce rules groups`() {
        val groups = listOf(
            listOf(listOf("row", "seat"), listOf("class", "row", "seat"), listOf("class", "row", "seat")),
            listOf(listOf("class", "row"), listOf("class", "row", "seat"), listOf("class", "row", "seat")),
            listOf(listOf("class", "row", "seat"), listOf("class", "row"), listOf("class", "row", "seat"))
        )
        val expected = listOf(listOf("row"), listOf("class", "row"), listOf("class", "row", "seat"))

        val result = Day16().reduceRulesGroup(groups)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `test reduce final rule`() {
        val groups = listOf(mutableListOf("row"), mutableListOf("class", "row"), mutableListOf("class", "row", "seat"))
        val expected = listOf("row", "class", "seat")

        val result = Day16().reduceFinal(groups, arrayOfNulls(groups.size))

        assertThat(result).containsExactlyElementsOf(expected)
    }

}
