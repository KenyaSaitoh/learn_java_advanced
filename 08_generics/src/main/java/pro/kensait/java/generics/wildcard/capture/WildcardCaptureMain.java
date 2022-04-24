package pro.kensait.java.generics.wildcard.capture;

// ワイルドカードキャプチャー
public class WildcardCaptureMain {
    public static void main(String[] args) {

        Hoge<Integer> hoge1 = new Hoge<Integer>();
        hoge1.setObject(10);
        Hoge<?> hoge2 = hoge1;

        // Hoge<?>からHoge<T>への代入はできない（コンパイルエラー）。
        // ただし、Hoge<T>型を引数とするメソッドに、Hoge<?>型を渡すことはできる。
        // これをワイルドカードキャプチャーと呼ぶ。
        // ワイルドカードキャプチャーとは、Hoge<?>型の実引数をHoge<T>型の仮引数に
        // 渡す際に、総称型Tに対する型が何らかの型に一意に決まり、型の安全性を
        // 保証できる場合にはコンパイルエラーにはしない、というもの。
        Fuga fuga = new Fuga();
        fuga.showElement1(hoge2);

        // ただし、以下のコードはコンパイルエラーになる。
        // fuga.showElement2(hoge2, new Integer(100));
        // この処理は、これだけ見ると問題ないように思える。
        // しかし、これを可能にしてしまうと、以下のようなコードもOKということに
        // なってしまうため、型の安全性が保証されない。
        // fuga.showElement2(hoge2, new Long(100));
    }
}