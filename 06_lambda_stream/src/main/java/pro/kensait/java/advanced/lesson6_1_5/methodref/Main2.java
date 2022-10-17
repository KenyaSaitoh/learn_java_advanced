package pro.kensait.java.advanced.lesson6_1_5.methodref;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main2 {
    public static void main(String[] args) {
        doList(System.out::println);
        doList(str -> System.out.println(str + str));
        doList(str -> {if (3 < str.length()) System.out.println(str);});
    }

    static void doList(Consumer<String> c) {
        List<String> strList = Arrays.asList("foo", "bar", "hoge");
        for (String str : strList) {
            c.accept(str);
        }
    }
}