package week3.w31_nullability

fun main() {
    //Nullable types in Kotlin
    val s1: String = "always not null"
    val s2: String? = null //после добавления вопроса, мы можем хранить нуль или не-нуль

    s1.length // OK

//    if (s2 != null) {
//        s2.length        or s2?.length
//    }
    s2?.length
//-----------

    //Nullability operators
    val s: String?

//    val length: Int = if (s != null) s.length else 0
//    val length: Int = s?.length ?: 0
    // ?: elvis operator
//--------

    //Control-flow analysis
    val ss: String?

//    if (ss == null) return
//    s.length
//---------



    //Making NPE explicit
/*      s!!

        если s != null ==> s
        если s == null ==> NPE
*/


//    class MyAction {
//        fun isEnabled(): Boolean =
//            list.selectedValue != null
//
//        fun actionPerformed() {
//            val value = list.selectedValue!!
//        }
//    }
//        if (action.isEnabled()) {
//            action.actionPerformed()
//        }


}