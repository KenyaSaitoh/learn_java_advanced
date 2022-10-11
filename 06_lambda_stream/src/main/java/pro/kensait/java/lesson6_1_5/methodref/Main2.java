package pro.kensait.java.lesson6_1_5.methodref;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main2 {
    public static void main(String[] args) {
        doList(System.out::println);
    }

    static void doList(Consumer<String> c) {
        List<String> strList = Arrays.asList("foo", "bar", "baz");
        for (String str : strList) {
            c.accept(str);
        }
    }
}