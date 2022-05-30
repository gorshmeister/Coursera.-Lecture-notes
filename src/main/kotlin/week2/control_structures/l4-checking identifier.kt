package week2.control_structures

fun isValidIdentifier(s: String): Boolean {
//    var b = false
//    for (char in s) {
//        if (s.get(0) == '_' || s.get(0).isLetter())
//            b = char.isLetterOrDigit() || char.equals('_')
//    }
//    return b
    fun isValidLetter(ch: Char) =
        ch == '_' || ch.isLetterOrDigit()
    if (s.isEmpty() || s[0].isDigit()) return false
    for (ch in s) {
        if (!isValidLetter(ch)) return false
    }
    return true
}


fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
    println(isValidIdentifier("no$$"))    // false
}