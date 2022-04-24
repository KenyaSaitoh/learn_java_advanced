package pro.kensait.java.lambda.block;

import java.util.function.BiFunction;

public class CalcFunctionMain {

    public static void main(String[] args) {
        new CalcFunctionMain().process();
    }

    private void process() {
        int answer1 = calc(30, 10, (a, b) -> a + b);
        System.out.println(answer1);

        int answer2 = calc(30, 10, (a, b) -> a - b);
        System.out.println(answer2);
    }

    private int calc(int x, int y, BiFunction<Integer, Integer, Integer> function) {
        if (50 < x) {
            throw new RuntimeException();
        }
        int value = function.apply(x, y);
        if (100 < value) {
            throw new RuntimeException();
        }
        return value;
    }
}