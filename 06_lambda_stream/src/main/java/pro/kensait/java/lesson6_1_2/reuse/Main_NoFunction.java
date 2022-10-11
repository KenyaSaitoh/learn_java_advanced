package pro.kensait.java.lesson6_1_2.reuse;

public class Main_NoFunction {
    public static void main(String[] args) {
        int answer1 = add(30, 10);
        System.out.println(answer1);

        int answer2 = subtract(30, 10);
        System.out.println(answer2);
    }

    static int add(int x, int y) {
        if (50 < x) {
            throw new RuntimeException("引数不正");
        }
        int value = x + y;
        if (100 < value) {
            throw new RuntimeException("計算結果不正");
        }
        return value;
    }

    static int subtract(int x, int y) {
        if (50 < x) {
            throw new RuntimeException("引数不正");
        }
        int value = x - y;
        if (100 < value) {
            throw new RuntimeException("計算結果不正");
        }
        return value;
    }
}