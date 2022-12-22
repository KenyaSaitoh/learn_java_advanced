package pro.kensait.java.advanced.lsn_4_1_6;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main_2 {
    public static void main(String[] args) {
        System.out.println("***** snippet_1 *****");
        doList(System.out::println);

        System.out.println("***** snippet_2 *****");
        doList(str -> System.out.println(str));

        System.out.println("***** snippet_3 *****");
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