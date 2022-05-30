package week4.w41_properties

/*
    Lazy property
    Ленивое свойство — это свойство, значения которого вычисляются только при первом доступе.
    Он ленив в том смысле, что ничего не сделает, если результат действительно не нужен.
    В Kotlin вы определяете ленивое свойство, используя ленивый синтаксис.
    Lazy — это функция, которая принимает лямбда в качестве аргумента.
    Внутри этой лямбды вы предоставляете способ вычисления значения, которое должно быть сохранено в этом свойстве.
 */
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}
/*
Когда вы обращаетесь к этому свойству, вы видите, что его значение вычисляется только один раз,
когда мы обращаемся к нему в первый раз. После этого сохраненное значение возвращается.
 */
//fun main() {
//    println(lazyValue)
//    println(lazyValue)
//}

/*
    Late initialization.
    Иногда мы хотим инициализировать свойство не в конструкторе, а в специально предназначенном для этого методе.
    Здесь мы инициализировали свойство myData в методе onCreate, а не в конструкторе.
    Мы не можем определить его как известное свойство, допускающее значение NULL, потому что у нас нет начального значения.
    Мы можем использовать null в качестве начального значения. Но в этом случае мы должны сделать свойство nullable.
    Затем каждый раз, когда мы обращаемся к нему, нам приходится справляться с обнуляемостью.
    Но мы знаем, что это свойство не может быть нулевым после правильной инициализации.
 */
//class KotlinActivity: Activity() {
//    var myData: MyData? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        myData = intent.getParcelableExtra("MY_DATA")
//    }
//
//    ...myData?.foo...
//}

/*
    Вот где свойства lateinit могут быть действительно полезными. Мы можем определить свойства lateinit.
После этого мы можем использовать его как значение ненулевого типа.

//class KotlinActivity: Activity() {
//    lateinit myData: MyData
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        myData = intent.getParcelableExtra("MY_DATA")
//    }
//
//    ...myData.foo...
//}
 */

/*
    lateinit constraints
Есть некоторые ограничения, которые применяются к свойствам lateinit. Например, это не может быть val.
Еще одно очевидное ограничение заключается в том, что тип этого свойства не может принимать значения NULL.
Другое ограничение заключается в том, что свойство lateinit не может иметь примитивный тип.
 */

/*
    Checking whether lateinit var was initialized
Можно проверить, было ли инициализировано свойство Laterinit. Для этого вы вызываете isInitialized ссылкой на свойство.
Мы видели примеры ссылок на элементы, включая ссылки на свойства, в предыдущем модуле. Это еще один случай,
когда ссылки на свойства могут быть полезны, когда вы проверяете, было ли ваше свойство lateinit инициализировано или нет.
 */

class MyClass {
    lateinit var lateinitVar: String

    fun initializationLogic() {
        println(this::lateinitVar.isInitialized) // false
        lateinitVar = "value"
        println(this::lateinitVar.isInitialized) // true
    }
}

fun main() {
    val myclass = MyClass()
    myclass.initializationLogic()
}
