package week4.w42_object_oriented_programming

import week4.w41_properties.MyClass

/*
    Constants

const (for primitive types and String)
@JvmField (eliminates accessors(get,set))

Если вы определяете константу примитивного типа строки в Kotlin, вы можете объявить ее с помощью модификатора const, что сделает ее константой времени компиляции.
Для ссылочных типов, если по какой-то причине вы не хотите генерировать геттеры под капотом, вы применяете аннотацию @JvmField,
которая будет указывать компилятору генерировать только поле.

    Compile-time constants
В Java, если примитивный тип или строка определены как константы, и их значение известно во время компиляции, компилятор заменяет имя константы везде в коде этим значением,
тогда оно называется compile-time constant. В Kotlin все константы времени компиляции отмечены явно. Когда вы добавляете const к свойству,
это делает его compile-time constant. Компилятор Kotlin также встраивает значение такой константы. Он заменяет свое имя своим значением везде в коде.
Обратите внимание, что он работает только для примитивных типов и строк.
 */
const val answer = 42



/*
    @JvmField
@JvmField предоставляет свойство как поле, оно делает его public, если свойство является public. Затем к этому полю можно получить доступ из Java.
Это полезно для некоторых фреймворков, которым нужны общедоступные поля. После применения аннотации @JvmField геттер не создается для свойства, доступного только для чтения,
и не создается сеттер, если свойство является изменяемым.
*/

@JvmField
val prop = MyClass()        // the same in Java - public static final MyClass prop = new MyClass();

/*
Здесь prop — это свойство верхнего уровня. Таким образом, применение @JvmField аналогично прямому определению статического поля.
Обратите внимание, что вы также можете исключить методы доступа(get, set) по соображениям производительности.


@JvmField делает свойство статическим, если оно используется на верхнем уровне или внутри объекта.
При использовании внутри обычного класса будет сгенерировано обычное поле.
 */
object A1 {
    @JvmField
    val prop = MyClass()    // static field generated
}

class B1 {
    @JvmField
    val prop = MyClass()    //  regular field generated
}




/*
    Property in an object
Когда вы просто определяете свойство внутри объекта, оно становится доступным из Java только через геттер. Потому что поле по умолчанию приватное.
Поскольку геттер доступен только как член поля экземпляра.

 */
object SuperComputer {
    val answer = 42
}
    //Java
    //SuperComputer.INSTANCE.getAnswer()


/*
 Чтобы сделать его доступным в качестве статического члена, вы можете применить аннотацию @JvmStatic.
Однако в этом случае вы можете получить доступ к геттеру только как к статическому члену, а не к полю. Это означает, что нет смысла применять свойства @JvmStatic.

object SuperComputer {
    @JvmStatic
    val answer = 42
}
    //Java
    //SuperComputer.getAnswer()     field isn`t exposed/Поле не открыто



 Чтобы открыть поле, примените аннотацию @JvmField.

 object SuperComputer {
    @JvmField
    val answer = 42
}
    //Java
    //SuperComputer.answer          /Поле открыто



 В случае примитивных типов и строк вы можете использовать модификатор const.

 object SuperComputer {
    const val answer = 42
}
    //Java
    //SuperComputer.answer          /Поле открыто
 */

