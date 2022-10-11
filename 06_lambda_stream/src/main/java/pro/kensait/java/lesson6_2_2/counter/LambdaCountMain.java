package pro.kensait.java.lesson6_2_2.counter;

import java.util.Arrays;
import java.util.List;

public class LambdaCountMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = list.stream().parallel()
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum);
    }
}