package pro.kensait.java.lesson6_2_2.counter;

import java.util.Arrays;
import java.util.List;

public class MultiLoopCountMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = 0; // 非finalなローカル変数にはアクセスできない

        ValueHolder value = new ValueHolder();

        for (Integer x : list) {
            Runnable r = () -> {
                value.total += x;
            };
            r.run();
        }
        System.out.println(value.total);
    }
}

class ValueHolder {
    int total;
}