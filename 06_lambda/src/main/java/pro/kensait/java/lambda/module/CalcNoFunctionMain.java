package pro.kensait.java.lambda.module;

public class CalcNoFunctionMain {
    public static void main(String[] args) {
        int answer1 = add(30, 10);
        int answer2 = subtract(30, 10);
        System.out.println(answer1);
        System.out.println(answer2);
    }

    static int add(int x, int y) {
        if (50 < x) {
            throw new RuntimeException();
        }
        int value = x + y;
        if (100 < value) {
            throw new RuntimeException();
        }
        return value;
    }

    static int subtract(int x, int y) {
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