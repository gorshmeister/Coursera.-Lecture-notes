package week3.w32_functionall_programming

class Person1(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit

    fun getAgePredicate() = this::isOlder

    override fun toString(): String {
        return "$name, $age"
    }
}

fun main() {
    val people = listOf(
        Person1("name", 20),
        Person1("name2", 22)
    )
    people.maxByOrNull { it.age }
// Синтаксис для ссылки на член: класс::член
    println(people.maxByOrNull(Person1::age))

/*
    You can store lambda in a variable. Вы можете хранить лямбду в переменной.
Но нельзя хранить функцию в переменной
 */
    fun isEven(i: Int): Boolean = i % 2 == 0
//    val predicate = isEven
//                  compiler error

/*
    Use function reference instead. Вместо этого используйте ссылку на функцию.
Ссылки на функцию позволяют хранить ссылку на любую определенную функцию в переменной
 */
    val predicate = ::isEven
//    val predicate = { i: Int -> isEven(i) }

/*
  Если член является свойством или это функция, которая принимает ноль или один аргумент,
тогда синтаксис ссылки на член не настолько сжат по сравнению с явным синтаксисом лямбды.

Однако, если упрекаемая функция принимает несколько аргументов, вам придется повторять все имена параметров как параметры Lambda,
а затем явно передавать их, что делает этот синтаксис надежным.
Ссылки на члены позволяют вам скрыть все параметры, потому что компилятор выводит типы за вас.
 */
    fun sendEmail(person: Person1, message: String) {
        val text = "Hi ${person.name} " + message
        println(text)
    }

//    val action = { person: Person1, message: String ->
//        sendEmail(person, message)
//    }

    val action = ::sendEmail

    action(people.get(1), "How are you?")

/*
    Passing function reference as an argument. Передача ссылки на функцию в качестве аргумента.
Всякий раз, когда ваша Lambda становится слишком большой и слишком сложной,
имеет смысл выделить код Lambda в отдельную функцию, тогда вы используете ссылку на эту функцию вместо огромной Lambda.
 */
    fun isEven1(i: Int): Boolean = i % 2 == 0

    val list1 = listOf(1,2,3,4)
    list1.any(::isEven1)    // true
    list1.filter(::isEven1) // [2, 4]


/*
    Bound & non-bound references. Связанные и несвязанные ссылки.
*/
/*
    Non-bound reference.
    В этом примере мы используем несвязанную ссылку, которая относится к члену класса Person1
Ссылка не связана с каким-либо конкретным экземпляром, вы можете вызвать её на любом объекте Person1
 */
//    val agePredicate: (Person1, Int) -> Boolean =
//        { person1, ageLimit ->
//            person1.isOlder(ageLimit)}

    val agePredicate = Person1::isOlder

    val alice = Person1("Alice", 29)
    agePredicate(alice, 21) // true

/*
    Bound reference.
Связанная ссылка = ссылка на член, которая прикреплена к конкретному экземпляру класса.
 */
    val agePredicate1 = alice::isOlder
    agePredicate1(21)   //true

/*
    Bound to this reference.

 */
    val predicate2 = alice.getAgePredicate()
    predicate2(22) // true

}
