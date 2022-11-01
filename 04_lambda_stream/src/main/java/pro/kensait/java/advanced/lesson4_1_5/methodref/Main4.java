package pro.kensait.java.advanced.lesson4_1_5.methodref;

import java.util.function.Consumer;

public class Main4 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Consumer<String> c1 = (msg) -> printer.print(msg);
        c1.accept("Hello, World!");

        Consumer<String> c2 = printer::print;
        c2.accept("Hello, World!");
    }
}