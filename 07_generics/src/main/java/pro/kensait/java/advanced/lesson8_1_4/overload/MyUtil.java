package pro.kensait.java.advanced.lesson8_1_4.overload;

public class MyUtil {

    // オーバーロード
    public static <T extends CharSequence> void process(T param) {
        System.out.println("[ process, 1st ] param => " + param);
    }

    public static <T extends Comparable<T>> void process(T param) {
        System.out.println("[ process, 2nd ] param => " + param);
    }
}