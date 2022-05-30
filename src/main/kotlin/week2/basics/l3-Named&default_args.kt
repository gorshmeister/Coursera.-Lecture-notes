package week2.basics

fun main() {
    //named and default arguments
    println(listOf('a','b','c').joinToString(" | ", "(", ")"))
    println(listOf('1','2','3').joinToString(postfix = "."))

    println("----------------------")

    //functions: default values
    fun displaySeparator(character: Char = '*', size: Int = 10) {
        repeat(size) {
            print(character)

        }
        println()
    }
    displaySeparator()
    displaySeparator('#', 5)
    displaySeparator('#')
    //functions: named arguments
    displaySeparator(size = 5)
    println("-----------------------")

    fun sum(a: Int = 0, b: Int = 0, c: Int = 0) = a + b + c
    println(sum(3))
    println(sum(3,5))
    println(sum(3,5,8))

}