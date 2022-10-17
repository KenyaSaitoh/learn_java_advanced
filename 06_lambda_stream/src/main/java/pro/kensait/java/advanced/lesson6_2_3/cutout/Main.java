package pro.kensait.java.advanced.lesson6_2_3.cutout;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 9, 2, 10, 3, 1, 5, 8, 7, 4);
        list.stream()
                .sorted()
                .skip(3)
                .limit(5)
                .forEach(System.out::println);
    }
}