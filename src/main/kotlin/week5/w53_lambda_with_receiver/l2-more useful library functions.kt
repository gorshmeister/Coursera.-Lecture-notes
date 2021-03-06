package week5.w53_lambda_with_receiver

import java.awt.SystemColor.window

class Windows(var width: Int, var height: Int, var isVisible: Boolean)

fun showWindow(w: Windows) {
    println("width: ${w.width}")
    println("height: ${w.height}")
    println("visible: ${w.isVisible}")
}



/*
    with
Мы уже видели, что он принимает выражение в качестве аргумента и использует его в качестве получателя внутри следующей лямбды.
Здесь мы можем получить доступ к членам окна без явного указания. Мы просто непосредственно свойства окна.
 */
/*
fun main() {
    val window = Windows(1, 2, false)
    with(window) {
        width = 300
        height = 200
        isVisible = true
    }
    println("${window.width}, ${window.height}, ${window.isVisible}")
}
*/

/*
    run: like with but extension
Run очень похож на with, но определяется как расширение, что позволяет использовать его с приемником, допускающим нуль. Если получатель, окно в нашем случае, может быть
нулевым, то вы не можете использовать with, потому что это будет иметь значение null внутри лямбда, тогда их нельзя допустить, вам нужно будет явно проверить, не является ли
оно нулевым. Run полезен в таком случае, потому что вы можете использовать его с безопасным доступом. Run будет вызываться только тогда, когда приемник не равен нулю.
Но учтите, что во многих других случаях run и with взаимозаменяемы.
 */
/*
fun main() {
    val windowById = mapOf<String, Windows>("main" to Windows(1, 2, false))

    val windowOrNull = windowById["main"]
    windowOrNull?.run {
        width = 300
        height = 200
        isVisible = true
    }

    if (windowOrNull != null) {
        println("${windowOrNull.width}, ${windowOrNull.height}, ${windowOrNull.isVisible}")
    }

//Вы можете использовать все выражение в качестве приемника, здесь запуск будет вызываться только тогда, когда основное значение windowById существует и не равно нулю.
    windowById["main"]?.run {
        width = 300
        height = 200
        isVisible = true
    }
}
*/


/*
    apply: returns receiver as result
Apply отличается тем, что в результате возвращает получателя. Мы не использовали его, но на самом деле функции with и run возвращают результат лямбды. Последнее выражение
внутри лямбды будет результатом всего вызова. Однако иногда бывает удобно вернуть получателя в качестве результата. Например, в цепочке вызовов вы можете вызывать другие
методы позже или снова, как в этом примере, просто присваивая результаты переменной. Когда вы создаете экземпляр окна, вы можете сразу же изменить некоторые его свойства.
'AppLy' действительно полезен для этого, потому что результатом является измененное главное окно. Обратите внимание, что здесь мы назначаем переменную только в том случае,
если результат не равен нулю, и если он равен нулю, мы останавливаем текущее выполнение и возвращаемся из внешней функции.
 */
/*
fun main() {
    val windowById = mapOf<String, Windows>("main" to Windows(1, 2, false))
    val mainWindow = windowById["main"]?.apply {
        width = 300
        height = 200
        isVisible = true
    } ?: return

}*/

/*
    also: regular argument instead of this
"ALso" похож на apply, он также возвращает получателя. Однако есть разница в том, что в качестве аргумента принимается обычная лямбда, а не лямбда с получателем.
Лямбда с приемником действительно полезна, когда вы можете допустить «эту» ссылку, потому что вы вызываете только ее члены. Однако бывают случаи, когда вы передаете получателю
аргумент, как здесь, когда мы передаем окно в качестве аргумента функции showWindow. В этом случае функция also лучше, потому что она принимает в качестве аргумента обычную
лямбду. Здесь это внутри «aLso» относится к окну.
 */
fun main() {
    val windowById = mapOf<String, Windows>("main" to Windows(1, 2, false))

    windowById["main"]?.apply {
        width = 300
        height = 200
        isVisible = true
    }?.also {
        window ->           // showWindow(it)
        showWindow(window)
    }
}

/*

Эта таблица показывает разницу между всеми этими функциями. "W1th" идет в клетку вместе с run. With здесь только одна функция, не являющаяся расширением.
Все остальные функции, включая run, являются расширениями. Разница между ними в том, какие функции возвращают результат лямбды, а какие функции возвращают приемник.
Функции в первом столбце принимают лямбду с получателем в качестве аргумента, "w1th" "Run" - как "apply". Остальные два принимают обычную лямбду в качестве аргумента.
https://i.imgur.com/OVkbzQE.png
 */
