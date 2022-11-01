package pro.kensait.java.advanced.lesson4_2_2.generate;

import java.util.Arrays;
import java.util.List;

public class Main_Collection {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream()
                .forEach(System.out::println);
    }
}
