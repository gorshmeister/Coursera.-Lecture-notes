package week3.w32_functionall_programming

import week3.w32_functionall_programming.Gender.*

fun main() {
    val heroes = listOf(
        Hero("The Captain", 60, MALE),
        Hero("Frenchy", 42, MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mate", 29, MALE),
        Hero("Sir Stephen", 37, MALE)
    )
/*
    9. Grouping by a given key
 */

    val mapByAge: Map<Int, List<Hero>> =
        heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxByOrNull { (_, group) ->
        group.size
    }!!
    println(age) // 29

/*
    10. Accessing map contents. Доступ к содержимому карты

    map[key] vs map.getValue(key)
    mapByName["unknown"]?.age          // null
    mapByName.getValue("unknown").age // NoSuchElementException
 */
    val mapByName: Map<String, Hero> =
        heroes.associateBy { it.name }
    mapByName["Frenchy"]?.age             // 42
    mapByName.getValue("Frenchy").age //42

/*
    11. associate
 */

    val mapByName1 = heroes.associateBy { it.name }
    val unknownHero = Hero("Unknown", 0, null)
    mapByName1.getOrElse("unknown") { unknownHero }.age // 0
}