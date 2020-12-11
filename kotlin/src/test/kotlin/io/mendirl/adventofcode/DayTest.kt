package io.mendirl.adventofcode

import java.io.File

open class DayTest(date: Int) {

    val inputs: List<String>

    init {
        val uri = Day1Test::class.java.getResource("/day$date.txt").toURI()
        inputs = File(uri).readLines()
    }

}
