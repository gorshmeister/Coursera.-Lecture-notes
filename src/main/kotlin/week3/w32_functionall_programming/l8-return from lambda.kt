package week3.w32_functionall_programming

fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return listOf()
        listOf(it, it)
    }
}

fun main() {
/*
    Return from function or lambda?
return в Kotlin всегда возвращается из функции, помеченной значком fun.
 */
    println(duplicateNonZero(listOf(3, 0, 5)))

    /*
        Why return from function?
    Return просто возвращается из функции.
    Если вы преобразуете цикл for в foreach, вы не можете ожидать, что return продолжит вести себя так же.
    Возврат внутри foreach также возвращает всю функцию.
     */
    fun containsZero(list: List<Int>): Boolean {
        for (i in list) {
            if (i == 0) return true
        }
        return false
    }

/*
    return from lambda
Вы можете использовать синтаксис возврата меток.
Здесь возврат метки будет возвращаться из соответствующей лямбды.
По умолчанию в качестве метки можно использовать имя функции, которая вызывает эту лямбду.
Solution using labels.
 */
    fun duplicateNonZero1(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0) return@flatMap listOf()
            listOf(it, it)
        }
    }
    println(duplicateNonZero1(listOf(3, 0, 5)))

/*
    Solution using local function
Вместо лямбда вы можете использовать локальную функцию,
а затем передать ссылку на эту локальную функцию.
В этом случае return ведет себя так, как ожидалось.
Он возвращается из локальной функции, отмеченной клавиатурой пруда.
 */

    fun duplicateNonZeroLocalFunction(list: List<Int>): List<Int> {
        fun duplicateNonZeroElement(e: Int): List<Int> {
            if (e == 0) return listOf()
            return listOf(e, e)
        }
        return list.flatMap(::duplicateNonZeroElement)
    }

    println(duplicateNonZeroLocalFunction(listOf(3, 0, 5)))

/*
    Solution using anonymous function
Теперь альтернативным решением является использование анонимной функции.
Вы можете определить анонимную функцию на месте, подобно лямбде, когда вы передаете ее в качестве аргумента.
По сути, это просто альтернативный синтаксис для лямбда-выражений.
Они под капотом реализации, скомпилированный байт-код будет одинаковым для лямбда и анонимной функции, и единственная разница синтаксическая.
 */
    fun duplicateNonZero3(list: List<Int>): List<Int> {
        return list.flatMap (fun (e): List<Int> {
            if (e == 0) return listOf()
            return listOf(e, e)
        })
    }

    println(duplicateNonZero3(listOf(3,0,5)))

/*
    return from anonymous function
Теперь вы можете использовать return, который возвращается из анонимной функции, помеченной ключевым словом fun.
Более того, вы можете указать тип возвращаемого значения для анонимной функции, что невозможно для лямбда.
 */
//    list.flatMap (fun (e): List<Int> {
//        if (e == 0) return listOf()
//        return listOf(e, e)
//    })


/*
    Another solution: no return
Иногда можно просто избежать возврата.
В этом случае мы используем результат if вместо return и получаем в результате то, что ожидаем.
 */
    fun duplicateNonZero(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0)
                listOf()
            else
                listOf(it, it)
        }
    }



}