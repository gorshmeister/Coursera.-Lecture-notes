package week3.w32_functionall_programming

fun main() {
    //function type
/*
    val sum = { x: Int, y: Int -> x + y }
   Если указать тип явно, мы увидим тип функции.
   Параметры - 2 инта, и возвращаемый тип инт
 */
    val sum: (Int, Int) -> Int = { x, y -> x + y }

    //Calling stored function. Вызов хранимой функции.
    val isEven: (Int) -> Boolean =
        { i: Int -> i % 2 == 0 }

    val result: Boolean = isEven(42) // true

/*
    Passing a variable of function type as an argument.
Передача переменной функционального типа в качестве аргумента.

    Когда мы храним лямбду в переменной, мы можем передать эту переменную всякий раз,
когда ожидается выражение типа функции
 */
    val list = listOf(1, 2, 3, 4)
    list.any(isEven)    // true
    list.filter(isEven) // [2, 4]

/*
    Calling lambda directly.
Мы можем вызвать лямбду на прямую, поставив после скобок лямбды ().
Однако если нужно запустить лямбду прямо на месте, лучше использовать run.
 */
//    val print = { println("hey") }()
    val print = run { println("hey") }

/*
    SAM interfaces in Java.
void postponeComputation(int delay, Runnable computation)

SAM (single abstract method) interface:

    public interface Runnable {
        public abstract void run();
    }
-----
    Lambdas and java
Когда мы вызываем метод, который принимает интерфейс SAM в качестве параметра,
мы можем прередать Лямбду в качестве аргумента этому методу

    postponeComputation(1000) { println(42) }

В котлин, если мы явно хотим создать экземпляр такого интерфейса,
мы можем использовать внешний сгенерированынй конструктор SAM и передать лямбда в качестве аргумента.

    val runnable = Runnable { println(42) }
    postponeComputation(1000, runnable)
 */

/*
    Function types and nullability. Типы функций и нулеспособность
        () -> Int?          vs      (() -> Int)?
return type is nullable         the variable is nullable

Первый означает, что возвращаемый тип является нулевым.
Второй означает, что весь тип nullable

 */

/*
    Working with a nullable function type. Работа с типом функции, допускающим значение NULL
Как вызвать переменную типа функции с нулевым значением? Вызвать обычной функцией не получится,
потому что она имеет значение null. -> Нужно явно проверить переменную на то, что она не равна нулю.
Или использовать синтаксис безопасного доступа
 */
    val f: (() -> Int)? = null

    if (f != null) {
        f()
    }

    f?.invoke()


}