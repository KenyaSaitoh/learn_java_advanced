package pro.kensait.java.advanced.lsn_8_1_6.wildcard.boundary_2;

import java.util.List;

public class MyNumberUtil {
    public static void process1(List<? extends Number> list) {
        Number num = list.get(0);
        System.out.println(num);

        // 以下はコンパイルエラー
        // list.add(100);
    }

    public static void process2(List<? super Integer> list) {
        // 以下はコンパイルエラー
        // Integer num = list.get(0);

        // Objectとしてしか取得できない
        Object num = list.get(0);
        System.out.println(num);

        // addはできる
        list.add(100);
    }
}