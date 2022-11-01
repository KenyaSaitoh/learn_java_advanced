package pro.kensait.java.advanced.lesson4_2_2.generate;

import java.util.Arrays;

public class Main_Array1 {
    public static void main(String[] args) {
        String[] strArray = {"foo", "bar", "baz"};
        Arrays.stream(strArray)
                .forEach(System.out::println);
    }
}
