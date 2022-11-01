package pro.kensait.java.advanced.lesson4_2_4.reduce;

import java.util.Arrays;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Alice", "Bob", "Carol", "Dave");
        String concatedString = strList.stream()
                .reduce((result, param) -> result + "/" + param)
                .orElse("");
        System.out.println(concatedString);
    }
}