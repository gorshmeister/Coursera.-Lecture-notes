package week3.w33_programming_assignment.nice_string

fun String.isNice2(): Boolean {
    val noBadSubstring = setOf("bu", "ba", "be").none { this.contains(it) }

    val hasThreeVowels = count { this in "aeiou" } >= 3

    val hasDouble = zipWithNext().any { it.first == it.second }

    return listOf(noBadSubstring, hasThreeVowels, hasDouble).count() { it } >= 2

}