package week3.w32_functionall_programming

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
/*
    filter - фильтрует содержимое списка и сохраняет только те эл., которые
    удовлетворяют заданному предикату
 */
    val filterList = list.filter { it % 2 == 0 }    // [2, 4, 6]
    println(filterList)

/*
    map - преобразует каждый элемент в коллекцию и сохраняет все результирующие эл.
    в новом списке
 */
    val mapList = list.map { it * it }      //[1, 4, 9, 16, 25, 36]
    println(mapList)

/*
    any (all, none) - предикаты, проверяющие, являются ли данные факты об элементах истинными
    any - хотя бы один, удовлетворяет
    all - все
    none - ни один
 */
    val anyList = list.any { it % 2 == 0 } // true
    println(anyList)

/*
    find / fitstOrNull - находит элемент удовлетворяющий предикату и возвращает его результат,
    если нет такого, то null
 */
    val findList = list.find { it % 2 == 0 } // 2
    println(findList)

/*
    count - подсчет элементов удовлетворяющих предикату
 */
    val countList = list.count { it % 2 == 0 } // 3
    println(countList)

/*
    partition - делит коллекцию на две коллекции. Одна соответствует условию, вторая - остальные
 */
    val partitionList = list.partition { it % 2 == 0 } // ([2, 4, 6], [1, 3, 5])
    println(partitionList)

/*
    groupBy - если нужно разделить коллекцию более чем на 2 группы.
    В качестве аргумента указывается способ группирования элементов
 */
    val persons = listOf<Person>(
        Person("Alice", 31),
        Person("Bob", 29),
        Person("Carol", 31)
    )
    val groupByPersons = persons.groupBy { it.age } // {31=[name: Alice age: 31, name: Carol age: 31],
    println(groupByPersons)                        // 29=[name: Bob age: 29]}

/*
    associateBy - если ключ уникален, то полезно иметь карту ключа к этому уник. эл.
    Возвращает один элемент в качетве значения карты.
    Если ключ не уникальный, то дубликаты удаляются
 */
    val associateByPersons = persons.associateBy { it.name } //{Alice=Alice, 31,
    println(associateByPersons)                             // Bob=Bob, 29,
    // Carol=Carol, 31}

/*
    associate - используется в качестве связующего для построения карты на основе списка.
    В качестве аргумента передается условие на создание пары, на основы каждого эл. списка.
    А затем, строит карту.
    {a=10,
    b=20,
    c=30,
    d=40,
    e=50,
    f=60}
 */
    val associateList = list.associate { '`' + it to 10 * it }
    println(associateList)

/*
    zip - предоставляет способ организовать несколько списков.
    Он застегивает, как молния элементы из двух списков.
    Возвращает список пар, где каждая пара содержит 1 эл из первого списка и другой из второго.
 */
    val listAbc = listOf('a', 'b', 'c', 'd', 'e', 'f')
    val zipList = list.zip(listAbc)
    println(zipList) // [(1, a), (2, b), (3, c), (4, d), (5, e), (6, f)]

/*
    zipWithNext - соединяет соседние элементы
 */
    val zipWithNext = list.zipWithNext()
    println(zipWithNext) // [(1, 2), (2, 3), (3, 4), (4, 5), (5, 6)]

/*
    flatten - функция расширения которая должна быть вызвана в списке списков.
    Он объединяет все элементы из вложенного списка и возвращает список этих эл.
            [ [a, b, c], [d, e], [f, g, h, i] ]
                [a, b, c, d, e, f, g, h, i]
 */
    val a = listOf('a', 'b', 'c')
    val b = listOf('d', 'e')
    val c = listOf('f', 'g', 'h', 'i')
    val abcList = listOf(a, b, c)
    println(abcList)
    val flattenList = abcList.flatten()
    println(flattenList)

/*
    flatMap - сочетает в себе 2 операции - map и flatten
    Аргумент flatMap должен быть лямбда, который преобразует каждый начальный эл. в список.
    abc         def
    [a b c]   [d e f]
    [a, b, c, d, e, f]
 */
    val lettersList = listOf("abc", "def")
    val flatMap = lettersList.flatMap { it.toList() }
    println(flatMap)

}

class Person(val name: String, val age: Int) {
    override fun toString(): String {
        return "$name, $age"
    }

}
