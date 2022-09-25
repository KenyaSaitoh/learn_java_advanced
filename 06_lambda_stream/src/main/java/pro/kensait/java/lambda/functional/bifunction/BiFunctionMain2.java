package pro.kensait.java.lambda.functional.bifunction;

import java.util.function.BiFunction;

public class BiFunctionMain2 {

    public static void main(String[] args) {
        new BiFunctionMain2().process();
    }

    private void process() {
        int answer1 = calcAnswer(30, 10, (a, b) -> a + b);
        System.out.println(answer1);

        int answer2 = calcAnswer(30, 10, (a, b) -> a - b);
        System.out.println(answer2);

        int answer3 = calcAnswer(30, 10, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a * b;
            };
        });
        System.out.println(answer3);
    }

    private int calcAnswer(int x, int y,
            BiFunction<Integer, Integer, Integer> function) {
        return function.apply(x, y);
    }
}