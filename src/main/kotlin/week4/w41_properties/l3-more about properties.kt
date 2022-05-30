package week4.w41_properties

/*
    Property in interface.
     Свойство можно определить в интерфейсе. Под капотом, это всего лишь геттер.
     Затем вы можете переопределить этот геттер в подклассах так, как вы хотите.
 */
interface User {
    val nickname: String
}

//class FacebookUser(val accountId: Int) : User {
//    override val nickname = getFacebookName(accountId)
//}

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

// Extension properties
val String.lastIndex: Int
    get() = this.length - 1

val String.indices: IntRange
    get() = 0..lastIndex

fun main() {
    val name = SubscribingUser("Viktor@bibis.ok")
    println(name.nickname)

    /*
        Extension properties.
        В Kotlin вы можете определить свойства расширения.
        Синтаксис очень похож на синтаксис определения функций расширения.
        Вы просто определяете свойство, но сначала указываете тип приемника.
     */

    "abc".lastIndex
    "abc".indices
    /*
    Вы можете получить доступ к ресиверу по этой ссылке внутри аксессуаров.
    Или вы можете создать эту ссылку и вызвать участников, как во втором примере.
    Вы можете вызывать свойства расширения так же, как они вызывают свойства члена.
    Синтаксис выглядит лучше так же, как и для функций расширения.
     */

    // *String.medianChar
    val s = "abc"
    println(s.medianChar)

    /*
       ** Mutable extension properties
        Вы можете определить изменяемые свойства расширения.
        Здесь мы определяем изменяемое свойство расширения lastChar в StringBuilder.
        Это позволяет нам получить или обновить последний символ.
        Затем вы можете использовать его как обычное свойство с кратким синтаксисом для доступа к setChar,
        который просто присваивает значение свойству.
     */

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

}

/*
// *String.medianChar
 Это свойство расширения скомпилировано в статический метод get medianChar с дополнительным скрытым параметром,
 который вызывается при каждом доступе. Свойства расширения очень похожи на функции расширения,
 но их единственная разница заключается в синтаксисе. Тот, что без скобок, когда вы называете это свойством.
 */
val String.medianChar
    get(): Char? {
        println("Calculating...")
        return getOrNull(length / 2)
    }

// ** Mutable extension properties
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }





