package pro.kensait.java.lesson6_1_1.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Japan", "France", "USA");
        Collections.sort(strList, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        System.out.println(strList);
    }
}