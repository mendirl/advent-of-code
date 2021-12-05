package io.mendirl.adventofcode21

import java.io.File
import java.lang.System.lineSeparator

open class DayTest(date: Int) {

    val inputs: List<String>

    init {
        val uri = DayTest::class.java.getResource("/day$date.txt").toURI()
        inputs = File(uri).readLines()
//        inputs = File(uri).readText().split(lineSeparator()).tail
    }

}
