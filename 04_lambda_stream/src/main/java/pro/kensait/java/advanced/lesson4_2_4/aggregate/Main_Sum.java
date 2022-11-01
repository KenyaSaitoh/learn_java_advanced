package pro.kensait.java.advanced.lesson4_2_4.aggregate;

import java.util.Arrays;
import java.util.List;

public class Main_Sum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long sum = list.stream()
                .mapToInt(x -> x * 10)
                .sum();
        System.out.println(sum);
    }
}