package io.mendirl.adventofcode20

import io.mendirl.adventofcode20.Direction.E
import kotlin.math.abs

class Day12 : Day {

    override fun step1(inputs: List<String>): Int {
        var (position, direction) = ((0 to 0) to E)

        inputs.toInstructions().forEach {
            when (it.action) {
                'L' -> direction = Direction.values()[(direction.ordinal + 3 * (it.value / 90)) % 4]
                'R' -> direction = Direction.values()[(direction.ordinal + 1 * (it.value / 90)) % 4]
                'F' -> position = move(position, direction, it.value)
                else -> position = move(position, Direction.valueOf(it.action.toString()), it.value)
            }
        }

        return position.manhattan()
    }


    override fun step2(inputs: List<String>): Int {
        var (position, waypoint) = ((0 to 0) to (10 to 1))

        inputs.toInstructions().forEach {
            when (it.action) {
                'L' -> (0 until it.value / 90).forEach { waypoint = (-waypoint.second to waypoint.first) }
                'R' -> (0 until it.value / 90).forEach { waypoint = (waypoint.second to -waypoint.first) }
                'F' -> position += (it.value * waypoint.first to it.value * waypoint.second)
                else -> waypoint = move(waypoint, Direction.valueOf(it.action.toString()), it.value)
            }
        }

        return position.manhattan()
    }
}

private fun Pair<Int, Int>.manhattan() = abs(this.first) + abs(this.second)

private fun move(pos: Pair<Int, Int>, dir: Direction, value: Int) =
    pos + (dir.x * value to dir.y * value)


enum class Direction(val x: Int, val y: Int) {
    N(0, 1),
    E(1, 0),
    S(0, -1),
    W(-1, 0)
}

data class Instruction(val action: Char, val value: Int)

fun List<String>.toInstructions(): List<Instruction> =
    this.map { Instruction(it[0], it.drop(1).toInt()) }

