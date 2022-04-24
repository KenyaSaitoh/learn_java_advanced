package pro.kensait.java.generics.case4;

public class GenericsMain4 {
    public static void main(String[] args) {
        Bar foo = new Bar();
        Moge moge = new Moge();

        // パターン1
        Hoge<Integer> hoge = moge.get();
        foo.execute(hoge);

        // パターン2
        foo.execute(moge.<Integer>get());
    }
}