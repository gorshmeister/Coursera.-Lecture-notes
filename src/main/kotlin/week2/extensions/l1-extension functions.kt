package week2.extensions

fun main() {
//    fun String.lastChar() = this.get(this.length - 1)
    fun String.lastChar() = get(length - 1)

    val c: Char = "abc".lastChar()
    println(c)

    // повторяет строку заданное кол-во раз
    fun String.repeat(n: Int): String {
        val sb = StringBuilder(n * length)
        for (i in 1..n)
            sb.append(this)
        return sb.toString()
    }

    val s = "abc".repeat(3)
    println(s)

}