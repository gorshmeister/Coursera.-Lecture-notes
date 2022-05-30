package week3.w33_programming_assignment.nice_string

fun String.isNice(): Boolean {
    var valid = 0

    if (!(this.contains("bu")
                || this.contains("ba")
                || this.contains("be"))
    )
        valid++


    var vowelsCount = 0
    this.forEach {
        if (it == 'a' ||
            it == 'e' ||
            it == 'i' ||
            it == 'o' ||
            it == 'u'
        )
            vowelsCount++
    }
    if (vowelsCount >= 3) valid++

    val doubleLetter = this.zipWithNext().count { it.first == it.second }
    if (doubleLetter >= 1) valid++

    return valid >= 2
}