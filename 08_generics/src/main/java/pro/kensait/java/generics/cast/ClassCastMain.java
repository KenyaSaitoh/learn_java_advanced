package pro.kensait.java.generics.cast;

public class ClassCastMain {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // Case1
        try {
            Foo foo = new Bar();
            Bar bar = (Bar)foo;
        } catch(ClassCastException cce) {
            System.out.println("Case1 : ClassCaseException Occurs!!!");
        }

        // Case2
        // 以下はコンパイルエラーになる
        // Foo foo2 = new Foo();
        // String str = (String)foo2;

        // Case3
        try {
            Foo foo = new Baz();
            Bar bar = (Bar)foo;
        } catch(ClassCastException cce) {
            System.out.println("Case3 : ClassCaseException Occurs!!!");
        }

        // Case4
        try {
            Foo foo = new Bar();
            Baz baz = (Baz)foo;
        } catch(ClassCastException cce) {
            System.out.println("Case4 : ClassCaseException Occurs!!!");
        }

        // Case5
        try {
            Foo foo = new Bar();
            Qux qux = (Qux)foo;
        } catch(ClassCastException cce) {
            System.out.println("Case5 : ClassCaseException Occurs!!!");
        }

        // Case6
        try {
            Object obj = new Bar();
            Foo foo = (Foo)obj;
        } catch(ClassCastException cce) {
            System.out.println("Case6 : ClassCaseException Occurs!!!");
        }

        // Case7
        try {
            Object obj = new Foo();
            Bar bar = (Bar)obj;
        } catch(ClassCastException cce) {
            System.out.println("Case7 : ClassCaseException Occurs!!!");
        }

        /*
         * 型の互換性はコンパイラでチェック可能。
         * 「何でnewされたか」は、コンパイラでは分からない。
         */
    }
}
