package pro.kensait.java.lambda.sum;

import java.util.Arrays;
import java.util.List;

public class LoopCountMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});

        int sum = 0;
        for (Integer x : list) {
            sum += x;
        }
        System.out.println(sum);
    }
}