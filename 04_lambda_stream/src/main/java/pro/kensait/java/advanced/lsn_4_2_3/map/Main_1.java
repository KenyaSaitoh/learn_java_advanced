package pro.kensait.java.advanced.lsn_4_2_3.map;

import java.util.Arrays;
import java.util.List;

public class Main_1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream()
                .map(x -> x * 2)
                .forEach(System.out::println);
    }
}
