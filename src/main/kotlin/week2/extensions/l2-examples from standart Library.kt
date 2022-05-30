package week2.extensions

fun main() {
    //Standard collections
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one",
        7 to "seven", 53 to "fifty-three")

    println(set)
    println(list)
    println(map)
//----------------

//Extension functions:

    // joinToString
    println(list.joinToString(";", "(", ")")) // (1;7;53)

    // getOrNull
    println("Number ${list.getOrNull(4)}") //Number null

    //withIndex
    for ((index, element) in list.withIndex()) { // 0: 1
        println("$index: $element")              // 1: 7
    }                                            // 2: 53

    //until.  1 until 10

    //to. Pair(this, that). mapOf(0 to "zero", 1 to "one")

    //isLetter. this in 'a'..'z' || this 'A'..'Z'
    //isLetterOrDigit. isLetter() || this '0'..'9'

    //Formatting multiline strings
    val q = """To code,
        |or not to code?..""".trimMargin() //обрезатьПоле - режет префикс |
    val a = """
        Keep calm
        and learn Kotlin""".trimIndent() //обрезатьОтступ
    println(q)
    println(a)
//------

    //Using regular expressions
//    val regex = "\\d{2}\\.\\d{2}\\.\\d{4}".toRegex()
    val regex = """\d{2}\.\d{2}\.\d{4}""".toRegex()

    println(regex.matches("15.07.2018")) //true
    println(regex.matches("15.07.18"))  //false
//----------

    //Conversion to numbers
    "123".toInt() //123
    "1e-10".toDouble() //1.0E-10

    // "xx".toInt() // NumberFormatException

    "123".toIntOrNull() // 123
    "xx".toIntOrNull() // null
//--------

    //Extension function: eq
    infix fun <T> T.eq(other: T) {
        if (this == other) println("OK")
        else println("Error: $this != $other")
    }

    fun getAnswer() = 42
    getAnswer() eq 42 // OK
    getAnswer() eq 43 // Error: 42 != 43




}