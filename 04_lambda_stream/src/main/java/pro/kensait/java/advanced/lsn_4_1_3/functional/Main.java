package pro.kensait.java.advanced.lsn_4_1_3.functional;

public class Main {
    public static void main(String[] args) {
        CalcFunction cf = (x, y) -> {
            return x + y;
        };
        int answer = cf.calc(30, 10);
        System.out.println(answer);
    }
}