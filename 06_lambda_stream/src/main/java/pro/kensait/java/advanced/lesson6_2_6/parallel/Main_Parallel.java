package pro.kensait.java.advanced.lesson6_2_6.parallel;

import java.util.Arrays;
import java.util.List;

public class Main_Parallel {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.parallelStream()
                .forEach(System.out::println);
    }
}
