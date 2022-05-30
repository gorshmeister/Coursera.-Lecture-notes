package week4.w41_properties

import week4.w41_properties.State.OFF
import week4.w41_properties.State.ON

/*
    Kotlin property
 */
class KotlinClass {
    var foo = 0
}

/*
    Read-only & mutable properties

property = field + accessor(s)

val = field + getter

var = field + getter + setter

 */

class Contact(val name: String, var address: String)

val foo2: Int
    get() {
        println("Calculating the answer...")
        return 42
    }


fun main() {
    val contact = Contact("Pasha", "Saint-P")
    contact.address // getter
    contact.address = "adress" //setter

    /*
        Backing field might be absent. Фоновое поле может отсутствовать
     */
    class Rectangle(val height: Int, val width: Int) {
        val isSquare: Boolean
            get() {
                return height == width
            }
    }

    val rectangle = Rectangle(2, 3)
    println(rectangle.isSquare)

    val foo1 = run {
        println("Calculating the answer...")
        42
    }
    println("$foo1 $foo1 $foo2 $foo2")
    /*
        Field
     */
    class StateLogger {
        var state = false
            set(value) {
                println("stati has changed: " +
                        "$field -> $value")
                field = value
            }
    }
    StateLogger().state = true

    /*
        Default accessors
    Если вы не определяете методы доступа для свойства, компилятор создает простой метод get,
    возвращающий значение поля, и простой метод set, обновляющий значение, если свойство является изменяемым
     */
    class A {
        var trivialProperty: String = "abc"
            get() = field
            set(value: String) {
                field = value
            }
    }

    /*
        You always use property instead of getter or setter. Вы всегда исп. свойство вместо геттера и сеттера
        Вы не обращаетесь к геттерам или сеттерам полей напрямую, вы используете только свойства как внутри, так и вне класса.
        Когда вы обращаетесь к счетчику здесь, вместо этого в качестве байт-кода вызывается getCounter.
        Однако внутри класса происходит оптимизация. Если методы доступа к свойствам тривиальны, их методы по умолчанию,
        которые возвращают вам значение или присваивают его, тогда вызов оптимизируется компилятором и заменяется прямым доступом к полю.
     */

    class LengthCounter {
        var counter: Int = 0

        fun addWord(word: String) {
            counter += word.length
        }
    }

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("HI")
    println(lengthCounter.counter)

    /*
        Accessors visibility. Видимость средств доступа
     */
    class LengthCounter1 {
        var counter: Int = 0
        private set

        fun addWord(word: String) {
            counter += word.length
        }
    }

    val lengthCounter1 = LengthCounter()
    lengthCounter1.addWord("Bibis")
    lengthCounter1.counter = 10
    println(lengthCounter1.counter)




}

enum class State { ON, OFF }

class StateLogger1 {
    private var boolState = false

    var state: State
        get() = if (boolState) ON else OFF
        set(value: State) {
            boolState = value == ON
        }
}
