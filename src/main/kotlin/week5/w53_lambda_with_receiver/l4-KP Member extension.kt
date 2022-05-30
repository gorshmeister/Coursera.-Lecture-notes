package week5.w53_lambda_with_receiver

class Words {
    private val list = mutableListOf<String>()

    fun String.record() {
        list.add(this)
    }

    operator fun String.unaryPlus() {
        record()
    }

    override fun toString() = list.toString()
}

fun main(args: Array<String>) {
    val words = Words()
    with(words) {
        // The following two lines should compile:
        "one".record()
        +"two"
    }
    words.toString() eq "[one, two]"
}


infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}