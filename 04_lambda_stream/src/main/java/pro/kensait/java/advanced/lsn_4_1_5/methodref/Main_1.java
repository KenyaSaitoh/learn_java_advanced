package pro.kensait.java.advanced.lsn_4_1_5.methodref;

import java.util.function.Consumer;

public class Main_1 {
    public static void main(String[] args) {
        Consumer<String> c = System.out::println;
        c.accept("Hello, World!");
    }
}