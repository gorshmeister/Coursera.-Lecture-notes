package week2.control_structures


fun main() {
    //(in) a range - проверка, находится ли символ в диапазоне
    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

    println(isLetter('q')) //true
    println(isLetter('8')) //false
    println()
//----

    //not (in) a range - проверка, НЕ находится ли символ в диапазоне
    fun isNotDigit(c: Char) = c !in '0'..'9'

    println(isNotDigit('q')) //true
    println(isNotDigit('8')) //false
    println()
//--------

    //(in) as (when)-condition - in в качестве условия для проверки, находится ли символ..
    fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "It`s a digit"
        in 'a'..'z', in 'A'..'Z' -> "It`s a letter"
        else -> "I don`t know.."
    }
    println(recognize('q')) //letter
    println(recognize('$')) //IDK
    println()
//--------

    //range of strings
    println("ball" in "a".."k") //true
    println("zoo" in "a".."k") //false
    println()
//--------

    //belonging to collection - содержится в коллекции (as list.contains)
    val list = listOf('1', '2', '3', '4', '5')
    val element = '3'

    if (element in list) println("List contains element!!")

}