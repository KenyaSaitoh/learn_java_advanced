package pro.kensait.java.advanced.lesson4_2_4.aggregate;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main_Avg {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        OptionalDouble opt = list.stream()
                .filter(x -> 5 < x)
                .mapToInt(x -> x)
                .average();
        double avg = opt.orElse(0.0d);
        System.out.println(avg);
    }
}