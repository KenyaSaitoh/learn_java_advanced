package pro.kensait.java.generics2.wildcard.boundary1;

import java.util.List;

public class PiyoApi {

    public void process1(List<? extends Number> list) {
        Number num = list.get(0);
        System.out.println(num);

        // 以下はコンパイルエラー
        // list.add(100);
    }

    public void process2(List<? super Integer> list) {
        // 以下はコンパイルエラー
        // Integer num = list.get(0);

        // Objectとしてしか取得できない
        Object num = list.get(0);
        System.out.println(num);

        // addはできる
        list.add(100);
    }
}