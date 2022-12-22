package pro.kensait.java.advanced.lsn_4_1_4.closure;

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
        Processor p = new Processor();
        p.process(cf);
    }
}