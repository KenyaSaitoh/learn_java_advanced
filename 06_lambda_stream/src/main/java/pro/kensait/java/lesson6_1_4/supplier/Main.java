package pro.kensait.java.lesson6_1_4.supplier;

import java.util.function.Supplier;

public class Main {
    static boolean infoLevel = true;

    public static void main(String[] args) {
        // ログを出力する（ラムダ式を渡す）
        info(() -> "THIS IS INFO LOG.");
    }

    static void info(Supplier<String> s) {
        if (infoLevel) {
            System.out.println("[ INFO ] " + s.get());
        }
    }
}