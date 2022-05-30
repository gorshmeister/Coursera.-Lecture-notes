package week4.w42_object_oriented_programming

/*
    sealed class. закрытый класс

Чтобы лучше понять это, давайте посмотрим на иерархию классов и посмотрим, как мы можем с ней работать. Мы собираемся представлять различные простые выражения.
Выражение — это либо число, либо сумма двух выражений. Представьте, что вам нужно оценить результат сохраненного выражения. За это будет отвечать функция eval.
    Class hierarchy
 */
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
    else -> throw IllegalArgumentException("Unknown expression")
}
/*
Вы, вероятно, написали бы такой код, используя выражение «когда», затем вы проверяете, является ли переменная числом типа или имеет тип суммы,
а затем делаете что-то соответственно. Проблема с этим кодом в том, что он не компилируется. Компилятор Kotlin говорит, что выражение «когда» не исчерпано.
Нет никакой гарантии, что нет других подклассов, реализующих интерфейс выражения, определенный где-то. Нет никакой гарантии, что ваш код не сломается из-за этого.
Чтобы сделать ваши намерения явными, здесь нам нужно предоставить ваш собственный подход к этой проблеме. Нужно точно сказать, что делать,
если не все подклассы присутствуют в ветках.
 */

/*
    sealed modifier
  Поскольку запечатанные модификаторы решают эту проблему для случая, когда вы уже знаете, что у вас полная иерархия, они ограничивают эту иерархию классов.
Теперь с модификатором seal нам не нужна ветвь else. Обратите внимание, что все подклассы должны присутствовать в том же файле, что и родительский запечатанный класс.
Это хорошо работает для простых иерархий. Отличие от предыдущего случая в том, что теперь выражение является классом, а не интерфейсом. Это связано с их базовой реализацией.
 Под капотом запечатанный класс имеет закрытый конструктор по умолчанию, так что вы не можете случайно создать экземпляр этого класса из Java или создать подклассы.
 */
sealed class Expr1
class Num1(val value: Int) : Expr1()
class Sum1(val left: Expr1, val right: Expr1) : Expr1()

fun eval1(e: Expr1): Int = when (e) {
    is Num1 -> e.value
    is Sum1 -> eval1(e.left) + eval1(e.right)
}
//// 1 + (2 + 3)
//fun main() {
//    val l = eval(Sum(Num(1), Sum(Num(2), Num(3))))  // 6
//    println(l)
//}


/*
    Inner and nested classes. Внутренние и вложенные классы

В Kotlin значения по умолчанию для вложенных и внутренних классов различаются. В Java, если вы забудете поставить static перед вложенным классом,
будет сгенерирована ссылка на внешний класс. Это то, что нужно иметь в виду. Если забыть об этом, то это может привести к утечкам памяти в ситуации,
когда вы уже не используете внешний класс, но обращение к ссылке все же сохраняется. В Котлине значение по умолчанию изменилось.
Теперь вы получаете статический вложенный класс по умолчанию. Тот, который не хранит ссылку на внешний класс.
Если вам нужна эта ссылка, вам нужно явно добавить inner модификатор.

    inner modifier. Внутренний модификатор
Чтобы получить доступ к этой ссылке внешнего класса, вы используете labeled this. В качестве имени метки вы указываете имя внешнего класса
 */
class AA {
    class B
    inner class C {
//        this@AA
    }
}

/*
    class delegation

Несколько слов о делегировании класса. Чтобы понять, зачем нам это нужно, давайте представим, что у вас есть пара интерфейсов и класс,
который реализует эти интерфейсы путем делегирования некоторых свойств. Вместо реализации всех методов вам просто нужно делегировать некоторые другие экземпляры.
Вы можете написать этот код вручную или сгенерировать методы делегирования, они тривиальны. Их может быть больше, если интерфейсы больше, и все, что имеет значение,
просто делегирует все реализации другим экземплярам.

 */

interface Repository {
    fun getById(id: Int): Contact
    fun getAll(): List<Contact>
}

interface Logger {
    fun logAll()
}

//class Controller(
//    val repository: Repository,
//    val logger: Logger,
//) : Repository, Logger {
//
//    override fun getById(id: Int): Contact = repository.getById(id)
//    override fun getAll(): List<Contact> = repository.getAll()
//
//    override fun logAll() = logger.logAll()
//}

/*
Используя делегирование класса, вы можете выразить ту же логику, просто сказав: «Я хочу реализовать этот интерфейс путем делегирования этому экземпляру».
Это «by» означает делегирование следующему экземпляру. По сути, делегирование класса позволяет вам делегировать задачу создания тривиальных вещей компилятору.
 */

class Controller(
    repository: Repository,
    logger: Logger,
) : Repository by repository, Logger by logger

//Обратите внимание, что класс контроллера реализует оба интерфейса, поэтому мы можем вызывать в нем элементы интерфейса.
fun use(controller: Controller) {
    controller.logAll()
    controller.getAll()
    controller.getById(1)
}

