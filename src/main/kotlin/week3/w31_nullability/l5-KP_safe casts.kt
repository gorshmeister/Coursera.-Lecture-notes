package week3.w31_nullability

fun main(args: Array<String>) {
    val s = 1.1
    println(s as? Int)    // null
    println(s as Int?)    // exception
}