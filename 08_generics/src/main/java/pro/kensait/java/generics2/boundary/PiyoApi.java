package pro.kensait.java.generics2.boundary;

public class PiyoApi {

    // オーバーロード
    public <T extends CharSequence> void process(T param) {
        System.out.println("[ 1st ] param => " + param);
    }

    public <T extends Comparable<T>> void process(T param) {
        System.out.println("[ 2nd ] param => " + param);
    }
}