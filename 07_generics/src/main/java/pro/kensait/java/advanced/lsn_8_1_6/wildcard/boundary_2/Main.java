package pro.kensait.java.advanced.lsn_8_1_6.wildcard.boundary_2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // 有界ワイルドカード（上限境界）
        MyNumberUtil.process1(list);

        // 有界ワイルドカード（下限境界）
        MyNumberUtil.process2(list);
    }
}