/**
 * Created by andrew on 19/04/2017.
 */

enum class Facing {
    NORTH, SOUTH, WEST, EAST
}

enum class Direction {
    Right, Left, None
}

class Step(var direction: Direction, var length: Short)

var facing = Facing.NORTH

fun main(args: Array<String>) {

    val directionsString = "R3, L2, L2, R4, L1, R2, R3, R4, L2, R4, L2, L5, L1, R5, R2, R2, L1, R4, R1, L5, L3, R4, R3, " +
            "R1, L1, L5, L4, L2, R5, L3, L4, R3, R1, L3, R1, L3, R3, L4, R2, R5, L190, R2, L3, R47, R4, L3, R78, L1, " +
            "R3, R190, R4, L3, R4, R2, R5, R3, R4, R3, L1, L4, R3, L4, R1, L4, L5, R3, L3, L4, R1, R2, L4, L3, R3, R3, " +
            "L2, L5, R1, L4, L1, R5, L5, R1, R5, L4, R2, L2, R1, L5, L4, R4, R4, R3, R2, R3, L1, R4, R5, L2, L5, L4, " +
            "L1, R4, L4, R4, L4, R1, R5, L1, R1, L5, R5, R1, R1, L3, L1, R4, L1, L4, L4, L3, R1, R4, R1, R1, R2, L5, " +
            "L2, R4, L1, R3, L5, L2, R5, L4, R5, L5, R3, R4, L3, L3, L2, R2, L5, L5, R3, R4, R3, R4, R3, R1"

    val directions = directionsString.split(", ")

    val steps = ArrayList<Step>()

    for (direction in directions) {
        val directionLetter = direction.substring(0, 1)
        val directionLegthString = direction.replace(directionLetter, "")

        steps.add(Step(if (directionLetter == "R") Direction.Right else Direction.Left, directionLegthString.toShort()))
    }

    for (step: Step in steps) {
        println("Direction: " + step.direction + " Length: " + step.length)
    }

    var x = 0
    var y = 0

    for (step: Step in steps) {

        //rotate
        when (facing) {
            Facing.NORTH -> {
                if (step.direction == Direction.Left) facing = Facing.WEST else facing = Facing.EAST
            }
            Facing.SOUTH -> {
                if (step.direction == Direction.Left) facing = Facing.EAST else facing = Facing.WEST
            }
            Facing.EAST -> {
                if (step.direction == Direction.Left) facing = Facing.NORTH else facing = Facing.SOUTH
            }
            Facing.WEST -> {
                if (step.direction == Direction.Left) facing = Facing.SOUTH else facing = Facing.NORTH
            }
        }

        when(facing) {
            Facing.NORTH -> y += step.length
            Facing.SOUTH -> y -= step.length
            Facing.WEST -> x -= step.length
            Facing.EAST -> x += step.length
        }
    }

    val totalDist = Math.abs(x) + Math.abs(y)

    println("Dist" + totalDist)



    //Part2

}