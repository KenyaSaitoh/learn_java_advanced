package org.study.se.lambda.foreach;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachMain1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});

        list.forEach(new Consumer<Integer>() {
            public void accept(Integer x) {
                System.out.println(x);
            }
        });
    }
}
