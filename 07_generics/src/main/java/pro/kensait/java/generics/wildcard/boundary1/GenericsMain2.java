package pro.kensait.java.generics.wildcard.boundary1;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain2 {
    public static void main(String[] args) {
        PiyoApi piyo = new PiyoApi();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(2); list1.add(3);

        // 有界ワイルドカード（上限境界）
        piyo.process1(list1);

        // 有界ワイルドカード（下限境界）
        piyo.process2(list1);
    }
}