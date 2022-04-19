package org.study.se.lambda.basic;

public class CalcMain {
    public static void main(String[] args) {
        CalcFunction calc1 = new CalcFunction() {
            @Override
            public int calc(int x, int y) {
                return x + y;
            }
        };
        calc1.calc(10, 20);

        CalcFunction calc2 = (int x, int y) -> {
            return x + y;
        };
        calc2.calc(10, 20);
    }
}