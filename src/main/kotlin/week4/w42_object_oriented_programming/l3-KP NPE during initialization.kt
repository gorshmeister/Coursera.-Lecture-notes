package week4.w42_object_oriented_programming

open class A(val value: String) {
    init {
        value.length
    }
}

class B(value: String) : A(value)

fun main(args: Array<String>) {
    val b = B("a")
    println(b.value)
}