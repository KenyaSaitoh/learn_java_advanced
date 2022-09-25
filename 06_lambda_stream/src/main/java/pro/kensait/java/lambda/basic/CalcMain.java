package pro.kensait.java.lambda.basic;

public class CalcMain {

    public static void main(String[] args) {
        CalcFunction calc1 = new CalcFunction() {
            @Override
            public int calc(int x, int y) {
                return x + y;
            }
        };
        int answer1 = calc1.calc(30, 10);
        System.out.println(answer1);

        CalcFunction calc2 = (int x, int y) -> {
            return x + y;
        };
        int answer2 = calc2.calc(30, 10);
        System.out.println(answer2);
    }
}

/* ======================================== */
@FunctionalInterface
interface CalcFunction {
    int calc(int x, int y);
}