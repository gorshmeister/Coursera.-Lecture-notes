package week2.control_structures

fun main() {
/*
    (throw) is an expression - выражение, если число входит в диапазон,
    то становится им, иначе бросается исключениe
*/
    val number = 99
    val percentage =
        if (number in 0..100)
            number
        else
            throw IllegalArgumentException(
                "A percentage value must be" +
                        "between 0 and 100: $number"
            )

    println(percentage)
//-------
/*
    try is an expression - проверка на наличие опред. типа.
    Пробуем запарсить строку, если парсится - присваиваем,
    иначе ловим исключение и присваиваем НУЛ
*/
    val string = "55s"

    val num = try {
        Integer.parseInt(string)
    } catch (e: NumberFormatException) {
        null
    }
    println(num)


}