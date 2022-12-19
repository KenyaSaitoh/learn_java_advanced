package pro.kensait.java.advanced.lsn_8_3_2.javase;

public class Main_CalcClient {
    public static void main(String[] args) {
        @SuppressWarnings("deprecation")
        int result1 = Calculator.add(30, 10);
        System.out.println(result1);

        @SuppressWarnings("removal")
        int result2 = Calculator.subtract(30, 10);
        System.out.println(result2);
    }
}