package week2.control_structures

fun main() {

//for
    val list = listOf("a", "b", "c")
    for (s in list) {
        print(s)
    }
    println()

    //iterating over map
    val map = mapOf(
        1 to "one",
        2 to "two",
        3 to "three")

    for ((key, value) in map) {
        println("$key = $value")
    }
    println("-------------")

    //iterating with index
    val list1 = listOf("a", "b", "c")
    for ((index, element) in list1.withIndex()) {
        println("$index : $element")
    }
    println("------------")

    //iterating over range
    for (i in 1..9) { // 1 - 9
        print(i)
    }
    println()
    for (i in 1 until 9) { // 1 - 8
        print(i)
    }
    println()

    //iterating with a step
    for (i in 9 downTo 1 step 2) { // 97531
        print(i)
    }
    println()

    //iterating over String
    for (ch in "abc") {  //bcd
        println(ch + 1)
    }

    for (c in '0' until '9') {
        print(c)
    }





}