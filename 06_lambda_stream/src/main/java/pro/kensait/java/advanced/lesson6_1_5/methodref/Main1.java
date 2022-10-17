package pro.kensait.java.advanced.lesson6_1_5.methodref;

import java.util.function.Consumer;

public class Main1 {
    public static void main(String[] args) {
        Consumer<String> c = System.out::println;
        c.accept("Hello, World!");
    }
}