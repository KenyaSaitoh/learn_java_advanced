package pro.kensait.java.advanced.lsn_4_2_3.map;

import java.util.Arrays;
import java.util.List;

public class Main_2 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Japan", "USA", "France");
        strList.stream()
                .map(str -> str.toUpperCase())
                .sorted()
                .forEach(System.out::println);
    }
}
