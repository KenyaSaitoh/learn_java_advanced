package org.study.se.lambda.count;

import java.util.Arrays;
import java.util.List;

public class LambdaCountMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});

        int sum = list.stream().mapToInt(i -> i).sum();
        System.out.println(sum);
    }
}