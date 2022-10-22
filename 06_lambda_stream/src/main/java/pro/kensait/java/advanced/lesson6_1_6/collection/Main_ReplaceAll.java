package pro.kensait.java.advanced.lesson6_1_6.collection;

import java.util.Arrays;
import java.util.List;

public class Main_ReplaceAll {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("foo", "bar", "baz");

        strList.replaceAll(str -> {
            return str.toUpperCase();
        });
        
        System.out.println(strList);
    }
}