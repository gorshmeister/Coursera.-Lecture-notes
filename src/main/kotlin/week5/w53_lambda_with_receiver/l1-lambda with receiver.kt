package week5.w53_lambda_with_receiver

/*
    the with function
Мы создаем StringBuilder, добавляем к нему несколько строк, а затем получаем результирующую строку. Наверное, мы намерены как-то его вернуть. Проблема в этом коде небольшая.
Тот, с которым все привыкли работать вообще, это то, что приходится несколько раз повторять имя переменной, вызывать над ней разные операции. Вы можете использовать with для
этого случая. Вам больше не нужно повторять их приёмник несколько раз. Вы можете вызывать все члены и расширения без явной спецификации получателя, как члены внутри класса.
Но самое интересное на этом слайде, это собственно его название. Она называется функцией with, поэтому with — это обычная функция, определенная в стандартной библиотеке.
 */
/*
fun main() {
    val sb = StringBuilder()
    sb.append("Alphabet: ")
    for (c in 'a'..'z') {
        sb.append(c)
    }
    sb.toString()
    println(sb)
//          f    ->
    val sb1 = StringBuilder()
    with(sb1) {
        append("Alphabet: ")
        for (c in 'a'..'z') {
            append(c)
        }
        toString()
    }
}
*/


/*
    lambda vs lambda with receiver
Существует также соответствие между способами вызова лямбда-выражений. Мы обсуждали, что вы можете хранить лямбда в переменной, и то же самое работает для лямбда-приемника.
Вы можете увидеть, как выглядит тип для лямбды с приемником в Котлине. Вы ставите тип приемника перед списком параметров, затем следует точка, затем параметры, как обычно,
в скобках. Тип возвращаемого значения указывается после стрелки, как всегда лямбда. Когда вы вызываете обычную лямбду, вы вызываете ее как обычную функцию. Вы можете вызвать
лямбду приемника, вы вызываете ее как функцию расширения. Вы видите эту переписку. Обычные лямбды соответствуют обычным функциям, лямбды с получателем соответствуют функциям
расширения.
 */
/*
fun main() {
    val isEven: (Int) -> Boolean = { it % 2 == 0 }
    val isOdd: Int.() -> Boolean = { this % 2 == 1 }

    println(isEven(1))      // calling as regular function
    println(1.isOdd())      // calling as extension function
}*/

/*
    Another example: buildString
Вам не нужно использовать with для построения строки, он использовался для иллюстрации. В реальной жизни вы можете использовать buildString для создания StringBuilder и преобразования его в строку. Он принимает лямбду с получателем в качестве аргумента.

buildString under the hood
https://i.imgur.com/xg3Kld5.png
 */
fun main() {
    val s: String = buildString {
        append("Alphabet: ")
        for (c in 'a'..'z') {
            append(c)
        }
    }
    println(s)
}
