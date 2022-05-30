package week5.w52_sequence

fun fibonacci(): Sequence<Int> = sequence {
    var el = Pair(0, 1)
    while (true) {
        yield(el.first)
        el = Pair(el.second,
            el.first + el.second)
    }
}

fun main(args: Array<String>) {
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}


infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}