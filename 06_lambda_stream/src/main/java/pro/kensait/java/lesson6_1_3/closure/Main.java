package pro.kensait.java.lesson6_1_3.closure;

public class Main {
    public static void main(String[] args) {
        int base = 100; // ローカル変数

        // ラムダ式で関数型インタフェースを実装する
        CalcFunction cf = (x, y) -> {
            return base + x + y;
        };
        int answer = cf.calc(30, 10);
        System.out.println(answer);

        // 遅延実行する
        process(cf);
    }

    static void process(CalcFunction cf) {
        int answer = cf.calc(30, 10);
        System.out.println(answer);
    }
}