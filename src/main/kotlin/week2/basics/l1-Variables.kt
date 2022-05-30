/*
val - read only
var - mutable

val greeting: String = "hi"
| equals |
val greeting = "hi"

 */


fun main() {
    val question = "Life, the universe, " +
            "and everything"
//    question = "sure?"  /error
    println(question)

    println()

    var answer = 0
    answer = 43
    println(answer)

    println()


    val languages = mutableListOf("1", "2", "3", "4", "5", "6")  // mutable list - изменяемый список
    println(languages)
    println(languages.get(3))

    val list = listOf(1, 2, 3, 4, 5, 6, 7)  //read-only list
    //    list.add(8) error



}