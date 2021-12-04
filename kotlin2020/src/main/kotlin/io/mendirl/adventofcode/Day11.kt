package io.mendirl.adventofcode

class Day11 : Day {
    override fun step1(inputs: List<String>): Int {
        val seats: Seats = inputs.map { it.toList() }

        return findStable(seats, 4, this::countNear)
    }

    override fun step2(inputs: List<String>): Int {
        val seats: Seats = inputs.map { it.toList() }

        return findStable(seats, 5, this::countSight)
    }

    fun findStable(seats: Seats, limit: Int, operation: (Seats, Seat) -> Int): Int {
        return generateSequence(seats) { round(it, limit, operation) }
            .zipWithNext()
            .first { it.first == it.second }
            .first
            .occupied()
    }

    fun round(seats: Seats, limit: Int, operation: (Seats, Seat) -> Int): Seats {
        return (seats.indices).mapIndexed { i, _ ->
            (seats.indices).mapIndexed { j, _ ->
                val currentSeat = Seat(i, j)
                val near = operation(seats, currentSeat)
                when {
                    seats[currentSeat.first][currentSeat.second] == 'L' && near == 0 -> '#'
                    seats[currentSeat.first][currentSeat.second] == '#' && near >= limit -> 'L'
                    else -> seats[currentSeat.first][currentSeat.second]
                }
            }
        }
    }

    fun countNear(seats: Seats, seat: Seat): Int {
        return sequenceOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        ).map { it + seat }
            .filter { it in seats }
            .count { seats[it.first][it.second] == '#' }
    }

    fun countSight(seats: Seats, seat: Seat): Int {
        return sequenceOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        ).map { neighbor ->
            generateSequence(seat + neighbor) {
                it + neighbor
            }.map {
                if (it in seats) seats[it.first][it.second] else null
            }.first {
                it == null || it != '.'
            }

        }.count { it == '#' }

    }

}


typealias Seats = List<List<Char>>
typealias Seat = Pair<Int, Int>

operator fun Seat.plus(that: Seat): Seat =
    Seat(this.first + that.first, this.second + that.second)

operator fun Seats.contains(seat: Seat): Boolean =
    seat.first in this.indices && seat.second in this.first().indices

fun Seats.occupied(): Int {
    return this.sumOf { it.count { it == '#' } }
}

