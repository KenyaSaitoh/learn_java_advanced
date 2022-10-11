package pro.kensait.java.lesson6_2_2.counter;

import java.util.Arrays;
import java.util.List;

public class RecursiveCountMain2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = calc(list, 0);
        System.out.println(sum);
    }

    // こっちは変数sumが不要。よりリカーシブっぽい。
    private static int calc(List<Integer> list, int i) {
        if (i < list.size()) {
            return list.get(i) + calc(list, ++i);
        } else {
            return 0;
        }
    }
}