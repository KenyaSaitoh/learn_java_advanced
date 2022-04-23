package pro.kensait.java.lambda.module;

import java.util.function.BiFunction;

public class CalcFunctionMain {
    public static void main(String[] args) {
        int answer1 = add(30, 10);
        int answer2 = subtract(30, 10);
        System.out.println(answer1);
        System.out.println(answer2);
    }

    static int add(int x, int y) {
        return calc(x, y, (a, b) -> a + b);
    }

    static int subtract(int x, int y) {
        return calc(x, y, (a, b) -> a - b);
    }

    static int calc(int x, int y, BiFunction<Integer, Integer, Integer> function) {
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