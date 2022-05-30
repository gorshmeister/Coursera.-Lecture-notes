package week4.w44_programming_assignment.rationals

import java.math.BigInteger

infix fun Int.divBy(other: Int): Rational {
    var i1 = this
    var i2 = other
    if (i1 < 0 && i2 < 0 || i2 < 0) {
        i1 *= -1
        i2 *= -1
    }

    val r1 = Rational(i1.toBigInteger())
    val r2 = Rational(i2.toBigInteger())

    return Rational((r1.numerator * r2.denominator), (r1.denominator * r2.numerator))
}

infix fun Long.divBy(other: Long): Rational {
    var i1 = this
    var i2 = other
    if (i1 < 0 && i2 < 0 || i2 < 0) {
        i1 *= -1
        i2 *= -1
    }
    val r1 = Rational(i1.toBigInteger())
    val r2 = Rational(i2.toBigInteger())

    return Rational((r1.numerator * r2.denominator), (r1.denominator * r2.numerator))
}

infix fun BigInteger.divBy(other: BigInteger): Rational {
    var i1 = this
    var i2 = other
    if (i1 < BigInteger("0") && i2 < BigInteger("0") || i2 < BigInteger("0")) {
        i1 *= BigInteger("-1")
        i2 *= BigInteger("-1")
    }

    val r1 = Rational(i1)
    val r2 = Rational(i2)

    return Rational((r1.numerator * r2.denominator), (r1.denominator * r2.numerator))
}

fun reductionToACommonDenominator(r1: Rational, r2: Rational) {
    if (r1.denominator != r2.denominator) {
        val commonDenominator = r1.denominator * r2.denominator

        r1.numerator = r1.numerator * r2.denominator
        r2.numerator = r2.numerator * r1.denominator

        r1.denominator = commonDenominator
        r2.denominator = commonDenominator
    }
}

fun copy(r1: Rational): Rational {
    return Rational(r1.numerator, r1.denominator)
}

class Rational() : Comparable<Rational> {
    var numerator = BigInteger("0")
    var denominator = BigInteger("1")

    constructor(numerator: BigInteger) : this() {
        this.numerator = numerator
    }

    constructor(numerator: BigInteger, denominator: BigInteger) : this() {
        if (denominator == BigInteger("0")) throw IllegalArgumentException()
        this.numerator = numerator
        this.denominator = denominator
    }

    operator fun plus(second: Rational): Rational {
        val r1 = copy(this)
        val r2 = copy(second)
        reductionToACommonDenominator(r1, r2)
        return Rational(r1.numerator + r2.numerator, r1.denominator)
    }

    operator fun minus(second: Rational): Rational {
        val r1 = copy(this)
        val r2 = copy(second)
        reductionToACommonDenominator(r1, r2)
        return Rational(r1.numerator - r2.numerator, r1.denominator)
    }

    operator fun times(second: Rational): Rational {
        val r1 = copy(this)
        val r2 = copy(second)
        return Rational(r1.numerator * r2.numerator, r1.denominator * r2.denominator)
    }

    operator fun div(second: Rational): Rational {
        val r1 = copy(this)
        val r2 = copy(second)
        val tmp = r2.numerator
        r2.numerator = r2.denominator
        r2.denominator = tmp
        return Rational(r1.numerator * r2.numerator, r1.denominator * r2.denominator)
    }

    operator fun unaryMinus(): Rational {
        val r1 = copy(this)
        r1.numerator = -r1.numerator

        return r1
    }

    override operator fun compareTo(other: Rational): Int {
        val r1 = copy(this)
        val r2 = copy(other)

        reductionToACommonDenominator(r1, r2)
        return if (r1.numerator == r2.numerator) 0
        else if (r1.numerator > r2.numerator) 1
        else -1
    }

    override fun equals(other: Any?): Boolean {
        return (other is Rational) && (this.toString() == other.toString())
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }

    override fun toString(): String {
        if (numerator.gcd(denominator) > BigInteger("1")) {
            val reduce = numerator.gcd(denominator)
            numerator /= reduce
            denominator /= reduce
        }
        return if (denominator == BigInteger("1")) {
            "$numerator"
        } else "${numerator}/${denominator}"
    }
}

fun String.toRational(): Rational {
    if (this.contains("/")) {
        val split = this.split("/")
        var i1 = split[0].toBigInteger()
        var i2 = split[1].toBigInteger()
        if (i1 < BigInteger("0") && i2 < BigInteger("0") || i2 < BigInteger("0")) {
            i1 *= BigInteger("-1")
            i2 *= BigInteger("-1")
        }
        return Rational(i1, i2)
    }
    return Rational(this.toBigInteger())
}
