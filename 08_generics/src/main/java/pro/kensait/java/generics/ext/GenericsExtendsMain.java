package pro.kensait.java.generics.ext;

// 総称型＋extends
public class GenericsExtendsMain {
    public static void main(String[] args) {
        Hoge<Integer> hoge = new Hoge<Integer>();
        hoge.setObject(new Integer(10));
        hoge.execute();
    }
}