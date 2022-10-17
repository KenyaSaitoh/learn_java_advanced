package pro.kensait.java.advanced.lesson6_1_4.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        doList(str -> System.out.println(str));
    }

    static void doList(Consumer<String> c) {
        List<String> strList = Arrays.asList("foo", "bar", "baz");
        for (String str : strList) {
            c.accept(str);
        }
    }
}