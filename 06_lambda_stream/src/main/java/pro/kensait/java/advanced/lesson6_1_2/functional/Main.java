package pro.kensait.java.advanced.lesson6_1_2.functional;

public class Main {
    public static void main(String[] args) {
        CalcFunction cf = (x, y) -> {
            return x + y;
        };
        int answer = cf.calc(30, 10);
        System.out.println(answer);
    }
}