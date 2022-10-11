package pro.kensait.java.lesson6_2_2.counter;

import java.util.Arrays;
import java.util.List;

public class LoopCountMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = 0;
        for (Integer x : list) {
            sum += x;
        }
        System.out.println(sum);
    }
}