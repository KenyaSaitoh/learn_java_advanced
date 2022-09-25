package pro.kensait.java.lambda.functional.supplier;

import java.util.function.Supplier;

public class LogWriterMain {
    private boolean infoLevel = true;

    public static void main(String[] args) {
        new LogWriterMain().process();
    }

    private void process() {
        // ログを出力する（ラムダ式を渡す）
        info(() -> "THIS IS INFO LOG.");

        // ログを出力する（Supplierオブジェクトを渡す）
        info(new Supplier<String>() {
            @Override
            public String get() {
                return "THIS IS INFO LOG.";
            }
        });
    }

    private void info(Supplier<String> message) {
        if (infoLevel) {
            System.out.println("[ INFO ] " + message.get());
        }
    }
}