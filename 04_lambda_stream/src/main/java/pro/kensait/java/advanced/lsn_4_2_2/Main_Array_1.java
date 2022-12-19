package pro.kensait.java.advanced.lsn_4_2_2;

import java.util.Arrays;

public class Main_Array_1 {
    public static void main(String[] args) {
        String[] strArray = {"foo", "bar", "baz"};
        Arrays.stream(strArray)
                .forEach(System.out::println);
    }
}
