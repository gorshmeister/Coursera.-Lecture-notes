package week4.w41_properties

import kotlin.random.Random

//var counter = 0
val foo: Int
    get() = Random.nextInt()

fun main(args: Array<String>) {
    // The values should be different:
    println(foo)
    println(foo)
    println(foo)
}