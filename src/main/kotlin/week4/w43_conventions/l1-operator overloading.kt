package week4.w43_conventions

import java.awt.Point

/*
    Arithmetic operations

В Kotlin вы можете использовать этот синтаксис арифметических операций не только для примитивов или строк, но и для пользовательских типов. Вы определяете функцию, член или
расширение с определенным именем и отмечаете его как оператор. Затем вы можете использовать краткий синтаксис для работы с вашим пользовательским типом. Ключевое слово
оператора здесь важно. Оно позволяет звонить плюсу как оператору.
    a + b -> a.plus(b)
 */
operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

//fun main() {
//    println(Point(1, 2) + Point(2, 3))  // [x=3,y=5]
//}


/*
    expression      function name
        +       ->      plus
        -       ->      minus
        *       ->      times
        /       ->      div
        %       ->      mod
 */

/*
    No restrictions on parameter type

Ограничений по типу параметра нет. Он не обязательно должен совпадать с типом приемника. Например, вы можете определить функцию, которая умножает точку и целое число.
 */
operator fun Point.times(scale: Int): Point {
    return Point(x * scale, y * scale)
}
//fun main() {
//    println(Point(1,2) * 3)
//}

/*
    Unary operations
Существует аналогичный список унарных операций. Унарный оператор — это функция без аргументов, которую мы можем вызвать как оператор для указанного получателя.
 */
operator fun Point.unaryMinus() = Point(-x, -y)
//fun main() {
//    println(-Point(3, 4))
//}

/*
        expression          function name
           +a       ->      unaryPlus
           -a       ->      unaryMinus
           !a       ->         not
        ++a, a++    ->         inc
        --a, a--    ->         dec

 */

/*
    Assignment operations
Есть два возможных значения их операций plusAssign. Во-первых, это может быть преобразовано в плюсовую функцию, если изменяемая переменная изменяется. Это означает, что вы просто изменяете его значение. Другой вариант — функция plusAssign. Если он определен, то эта операция может быть разрешена для вызова plusAssign под капотом.

        a = a.plus(b)
a += b
        a.plusAssign
 */

/*
    Conventions for lists
Это соглашение работает для списка. Если вы используете плюс в возвращаемом списке, обратите внимание, что тогда он создаст новый список и вернет его в качестве результата. Из mutableList вы можете использовать plusAssign, и он вызывает соответствующую функцию plusAssign.
 */
fun main() {
    var list = listOf(1, 2, 3)                //check val & var
    println("$list, ${list.hashCode()}")
    list += 2
    println("$list, ${list.hashCode()}")
/*
    Prefer val to var
Неправильно писать такой код. Под капотом создается новый список, если вы определяете регион в списке как var и что-то добавляете в него. Помните об этом. Это еще одна причина предпочесть val var.
 */

    val mutableList = mutableListOf(1, 2, 3)
    mutableList += 4
    println(mutableList)
}
