package org.study.se.lambda.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapMain1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});

        List<Integer> list2 = list.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
