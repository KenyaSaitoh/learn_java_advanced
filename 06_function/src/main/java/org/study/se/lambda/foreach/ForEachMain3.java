package org.study.se.lambda.foreach;

import java.util.Arrays;
import java.util.List;

public class ForEachMain3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});

        list.forEach(System.out::println);
    }
}