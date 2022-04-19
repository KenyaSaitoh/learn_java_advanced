package org.study.se.lambda.module;

import java.util.function.BiFunction;

public class CalcFunctionMain {
    public static void main(String[] args) {
        System.out.println(add(20, 10));
        System.out.println(subtract(20, 10));
    }

    static int add(int x, int y) {
        return calc(x, y, (a, b) -> a + b);
    }

    static int subtract(int x, int y) {
        return calc(x, y, (a, b) -> a - b);

    }

    static int calc(int x, int y, BiFunction<Integer, Integer, Integer> f) {
        if (50 < x) {
            throw new RuntimeException();
        }
        int answer = f.apply(x, y);
        if (100 < answer) {
            throw new RuntimeException();
        }
        return answer;
    }
}
