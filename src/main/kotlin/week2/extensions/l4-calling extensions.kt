package week2.extensions

open class Parent
class Child : Parent()

fun Parent.foo() = "parent"
fun Child.foo() = "child"

fun main() {
    val parent: Parent = Child()
    println(parent.foo()) // parent

    /*
    Функции расширения внутри являются статическими функциями,
        для них не работает переопределение
    */
    fun String.get(index: Int) = '*'
    println("abc".get(1)) // b

    //Extensions don`t hide members
    /*
      Если мы пытаемся определить функцию-расширение с такой же сигнатурой,
      как и в функции-элементе, то получим предупреждение, что фунцкия-расширение скрыта,
      поэтому функция-элемент будет всегда выбираться вместо неё
     */
    class A {
        fun foo() = 1
    }

    fun A.foo() = 2

    println(A().foo()) // 1

    /*
        Однако, мы можем перегузить функцию-элемент,
        определить функцию-расширение с иной сигнатурой.
        Новая функция будет вызываться, если она лучше подходит
     */

    fun A.foo(i: Int) = "extension($i)"

    println(A().foo(2)) //extension(2)




}