package week3.w32_functionall_programming

import week3.w32_functionall_programming.Gender.*

data class Hero(
    val name: String,
    val age: Int,
    val gender: Gender?
)
enum class Gender {MALE, FEMALE}

fun main() {
    val heroes = listOf(
        Hero("The Captain", 60, MALE),
        Hero("Frenchy", 42, MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mate", 29, MALE),
        Hero("Sir Stephen", 37, MALE)
    )
//  1. first, last, firstOrNull, lastOrNull
    heroes.last().name // Sir Stephen

/*
    2.  first {...}, last {...},
    firstOrNull {...}, lastOrNull {...}
 */
    heroes.firstOrNull { it.age == 30 }?.name //null
//    heroes.first { it.age == 30 }.name // NoSuchElementException


/*
    3. distinct: find only distinct elements. Отличающиеся элементы
    heroes.map { it.age }               // [60, 42, 9, 29, 29, 37]
    heroes.map { it.age }.distinct()    // [60, 42, 9, 29, 37]

 */
    heroes.map { it.age }.distinct().size // 5

/*
    4. Filtering the list contents. Фильтрация содержимого списка
 */
    heroes.filter { it.age < 30 }.size //   3

/*
    5. partition: two collections as a result. Делит список эл. на 2 списка
 */
    val (youngest, oldest) = heroes.partition { it.age < 30 }
    oldest.size // 3

/*
    6. Finding the maximum
 */
    heroes.maxByOrNull { it.age }?.name // The Captain

/*
    7. Predicates. Утверждения
 */
    heroes.all { it.age < 50 } // false
//    8.
    heroes.any { it.gender == FEMALE } // true
}
