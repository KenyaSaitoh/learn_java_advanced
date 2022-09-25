package pro.kensait.java.lambda.functional.bifunction;

public class BiFunctionMain1 {

    public static void main(String[] args) {
        new BiFunctionMain1().process();
    }

    private void process() {
        int answer1 = calcAnswer(30, 10, (a, b) -> a + b);
        System.out.println(answer1);

        int answer2 = calcAnswer(30, 10, (a, b) -> a - b);
        System.out.println(answer2);

        int answer3 = calcAnswer(30, 10, new CalcFunction() {
            @Override
            public int calc(int a, int b) {
                return a * b;
            };
        });
        System.out.println(answer3);
    }

    private int calcAnswer(int x, int y, CalcFunction function) {
        return function.calc(x, y);
    }
}

/* ======================================== */
@FunctionalInterface
interface CalcFunction {
    int calc(int x, int y);
}