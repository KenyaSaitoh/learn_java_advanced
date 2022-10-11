package pro.kensait.java.lesson6_2_1.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapMain1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> list2 = list.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
