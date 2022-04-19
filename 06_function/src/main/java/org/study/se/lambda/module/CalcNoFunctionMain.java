package org.study.se.lambda.module;

public class CalcNoFunctionMain {
    public static void main(String[] args) {
        System.out.println(add(20, 10));
        System.out.println(subtract(20, 10));
    }

    static int add(int x, int y) {
        if (50 < x) {
            throw new RuntimeException();
        }
        int answer = x + y;
        if (100 < answer) {
            throw new RuntimeException();
        }
        return answer;
    }

    static int subtract(int x, int y) {
        if (50 < x) {
            throw new RuntimeException();
        }
        int answer = x - y;
        if (100 < answer) {
            throw new RuntimeException();
        }
        return answer;
    }
}
