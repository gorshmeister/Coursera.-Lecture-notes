package week2.control_structures

import week2.control_structures.Color.*

enum class Color {
    BLUE, ORANGE, RED
}

fun main() {
    //if is an expression - (если) это выражение
    val a = 3
    val b = 4
    val max = if (a > b) a else b
    println(max)
    println("-------------------")

    //when as switch - аналог switch из Java
    fun getDescription(color: Color): String =
        when (color) {
            BLUE -> "cold"
            ORANGE -> "mild"
            RED -> "hot"
        }
    println(getDescription(BLUE))
    println("-------------------")

    //no break is needed
    val color = RED
    when (color) {
        BLUE -> println("cold")
        ORANGE -> println("mild")
        else -> println("hot")
    }
    println("-------------------")

    //checking values
    fun respondToInput(input: String) = when (input) {
        "y", "yes" -> "I`m glad you agree"
        "n", "no" -> "Sorry to hear that"
        else -> "I don`t understand you"
    }
    println(respondToInput("yes"))
    println(respondToInput("yessssss"))
    println("-------------------")

    //any expression can be used as a branch condition -любое выражение может быть использовано как условие ветвления
//    fun mix(c1: Color, c2: Color) =
//        when (setOf(c1, c2)) {
//            setOf(RED, YELLOW) -> ORANGE
//            setOf(YELLOW, BLUE) -> GREEN
//            setOf(BLUE, VIOLET) -> INDIGO
//            else -> throw Exception("Dirty color")
//        }

    //checing types | is как instanceof
    val pet: Pet = Cat()
    when (pet) {
        is Cat -> pet.meow()
        is Dog -> pet.woof()
    }
    println("-------------------")


    //checking conditions: (when) without arguments
    /**
     * Java analog ->>>>>>>
     *
     * String description;
     * Colour colour;
     * if (degrees < 5) {
     *      description = "cold";
     *      colour = BLUE;
     * } else if (degrees < 23) {...}
     */
    fun updateWeather(degrees: Int) {
        val (description, color) = when {
            degrees < 5 -> "cold" to BLUE
            degrees < 23 -> "mild" to ORANGE
            else -> "hot" to RED
        }
    }


}

open class Pet {}
class Cat : Pet() {
    fun meow() = println("meow")
}

class Dog : Pet() {
    fun woof() = println("woof")
}
