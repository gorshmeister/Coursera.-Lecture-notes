package week3.w33_programming_assignment.nice_string

fun String.isNice1(): Boolean {
    val noBadSubstring = !contains("bu") && !contains("ba") && !contains("be")

    val hasThreeVowels = count {
        it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u'
    } >= 3

    var hasDouble = false
    if (length > 1) {
        var prevChar: Char? = null
        for (ch in this) {
            if (prevChar == ch)
                hasDouble = true
            prevChar = ch
        }
    }

    var conditions = 0
    if (noBadSubstring) conditions++
    if (hasThreeVowels) conditions++
    if (hasDouble) conditions++

    if (conditions >= 2) return true
    return false
}