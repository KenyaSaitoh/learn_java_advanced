package pro.kensait.java.generics.wildcard.capture;

// ワイルドカードキャプチャー
public class WildcardMain {
    public static void main(String[] args) {

        Foo<Integer> foo1 = new Foo<>();
        Foo<?> foo2;

        // Foo<?>に対してFoo<T>を代入することは可能。
        foo2 = foo1;

        // Foo<T>に対してFoo<?>を代入することはできない（コンパイルエラー）。
        // foo1 = foo2;

        // Foo<T>の仮引数に対して、Foo<?>の実引数を渡す際に、
        // Tに対する型が何らかの型に一意に決まり、型の安全性を保証できる場合には
        // コンパイルエラーにはならない（ワイルドカードキャプチャー）。
        HogeApi hoge = new HogeApi();
        hoge.printProperty1(foo2);

        // ただし、以下のコードはコンパイルエラーになる。
        // hoge.printProperty2(foo2, 100);

        // この処理は、これだけ見ると問題ないように思える。
        // しかし、これを可能にしてしまうと、以下のようなコードもOKということに
        // なってしまうため、型の安全性が保証されない。
        // hoge.printProperty2(foo2, 100L);
    }
}