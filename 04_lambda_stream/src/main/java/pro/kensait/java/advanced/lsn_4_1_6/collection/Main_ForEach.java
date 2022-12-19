package pro.kensait.java.advanced.lsn_4_1_6.collection;

import java.util.Arrays;
import java.util.List;

public class Main_ForEach {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

         // ラムダ式を渡す
        list.forEach(x -> System.out.println(x));

        // メソッド参照を渡す
        list.forEach(System.out::println);
    }
}