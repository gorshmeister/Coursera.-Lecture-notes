package week2.basics
fun main() {
    val a = 3
    val b = 4

    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    // max equals max2
    fun max2(a: Int, b: Int) = if (a > b) a else b

    println(max(a, b))
    println(max2(a, b))

    fun displayMax(a: Int, b: Int): Unit { // Unit = void
        println(max(a, b))
    }
    displayMax(a, b)





}