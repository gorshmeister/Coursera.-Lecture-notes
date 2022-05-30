package week3.w31_nullability

fun main() {
    //under the hood

    fun foo(): String = "foo"
    /*

    @NotNull
    public static final String foo() {
        return "foo";
    }
     */

    fun bar(): String? = "bar"
    /*

    @Nullable
    public static final String bar() {
        return "bar";
    }
     */
//-----

    //List of nullable elements vs nullable list
//          List<Int?>              List<Int>?

    fun foo(list1: List<Int?>) {
        list1.size

        val i: Int? = list1.get(0)
    }

    fun bar(list1: List<Int>?) {
        list1?.size

        val i: Int? = list1?.get(0)
    }

}