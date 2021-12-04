package io.mendirl.adventofcode

class Day2 : Day {
    override fun step1(inputs: List<String>): Int {
        return inputs
            .count {
                valid(it)
                { l, u, c, pwd -> (l..u).contains(pwd.occurences(c)) }
            }
    }

    override fun step2(inputs: List<String>): Int {
        return inputs
            .count {
                valid(it)
                { l, u, c, pwd -> (pwd[l - 1] == (c)) != (pwd[u - 1] == (c)) }
            }
    }

    private val regex = Regex("(\\d+)-(\\d+) (\\w): (\\w*)")

    private fun valid(data: String, predicate: (l: Int, u: Int, c: Char, pwd: String) -> Boolean): Boolean {
        val (l, u, c, pwd) = regex.find(data)!!.destructured
        return predicate(l.toInt(), u.toInt(), c[0], pwd)
    }

}

private fun String.occurences(c: Char): Int {
    return this.count { it == c }
}
