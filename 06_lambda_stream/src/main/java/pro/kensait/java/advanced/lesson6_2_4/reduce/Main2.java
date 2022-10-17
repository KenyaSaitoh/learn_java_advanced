package pro.kensait.java.advanced.lesson6_2_4.reduce;

import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Alice", "Bob", "Carol", "Dave");
        int strLength = strList.stream()
                .mapToInt(str -> str.length())
                .reduce((result, param) -> result + param)
                .orElse(0);
        System.out.println(strLength);
    }
}