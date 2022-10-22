package pro.kensait.java.advanced.lesson8_1_6.wildcard.boundary1;

import java.util.List;

public class MyNumberUtil {
    public static void printSum1(List<Number> list) {
        long total = 0;
        for (Number num : list) {
            total = total + num.longValue();
        }
        System.out.println(total);
    }

    public static void printSum2(List<? extends Number> list) {
        long total = 0;
        for (Number num : list) {
            total = total + num.longValue();
        }
        System.out.println(total);
    }
}