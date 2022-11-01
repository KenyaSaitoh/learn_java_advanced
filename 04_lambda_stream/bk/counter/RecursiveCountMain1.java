package pro.kensait.java.lesson6_2_5.counter;

import java.util.Arrays;
import java.util.List;

public class RecursiveCountMain1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = calc(list, 0, 0);
        System.out.println(sum);
    }

    private static int calc(List<Integer> list, int i, int sum) {
        if (i < list.size()) {
            sum += list.get(i);
            i++;
            return calc(list, i, sum);
        } else {
            return sum;
        }
    }
}