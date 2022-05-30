package week2.programming_assignment

fun main() {
    val rightPos = "BCDF".zip("ACEB").count() {it.first == it.second}
    println(rightPos)
}