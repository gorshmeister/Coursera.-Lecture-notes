package week3.w31_nullability

fun main() {
    val s1: String? = null
    val s2: String? = ""
    s1.isEmptyOrNull() eq true
    s2.isEmptyOrNull() eq true

    val s3 = "   "
    s3.isEmptyOrNull() eq false
}

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}

fun String?.isEmptyOrNull() =
    this == null || this.isEmpty()
//equals
fun isEmptyOrNull1(s: String?) = s == null || s.isEmpty()
