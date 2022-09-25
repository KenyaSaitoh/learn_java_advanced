package pro.kensait.java.lambda.block;

public class CalcNoFunctionMain {

    public static void main(String[] args) {
        new CalcNoFunctionMain().process();
    }

    private void process() {
        int answer1 = add(30, 10);
        System.out.println(answer1);

        int answer2 = subtract(30, 10);
        System.out.println(answer2);
    }

    private int add(int x, int y) {
        if (50 < x) {
            throw new RuntimeException();
        }
        int value = x + y;
        if (100 < value) {
            throw new RuntimeException();
        }
        return value;
    }

    private int subtract(int x, int y) {
        if (50 < x) {
            throw new RuntimeException();
        }
        int value = x - y;
        if (100 < value) {
            throw new RuntimeException();
        }
        return value;
    }
}