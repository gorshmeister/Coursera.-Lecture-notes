package week3.w31_nullability

fun main() {
//Безопасный способ приведения выражения к типу
    //Type cast: as

    val any = readLine()
    if (any is String) {
        val s = any as String
        s.toUpperCase()
    }
//equals
    if (any is String) {
        any.toUpperCase()
    }
/*
    cast as выдает исключение, если выражение не может быть приведено,
    а save cast as? возвращает null в этом случае
 */
    (any as? String)?.toUpperCase()

    val a = readLine()
    val s = if (a is String) a else null
//equals
    val ss: String? = any as? String
}