package pro.kensait.java.advanced.lesson8_1_6.wildcard.boundary1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Long> longList = Arrays.asList(1L, 2L, 3L);

        // コンパイルエラー
        //MyNumberUtil.printSum1(intList);

        // どっちもOK
        MyNumberUtil.printSum2(intList);
        MyNumberUtil.printSum2(longList);
    }
}