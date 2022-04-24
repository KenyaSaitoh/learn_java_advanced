package pro.kensait.java.lambda.counter;

import java.util.Arrays;
import java.util.List;

public class RecursiveCountMain2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> subList1 = list.subList(0, 5);
        List<Integer> subList2 = list.subList(5, 10);
        System.out.println(subList1);
        System.out.println(subList2);
        int sum1 = calc(subList1, 0);
        int sum2 = calc(subList2, 0);
        System.out.println(sum1 + sum2);
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