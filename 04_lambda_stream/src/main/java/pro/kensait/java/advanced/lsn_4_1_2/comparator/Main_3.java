package pro.kensait.java.advanced.lsn_4_1_2.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_3 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Japan", "USA", "France");
        Collections.sort(strList, (s1, s2) -> { //【1】
            return s1.length() - s2.length();
        });
        System.out.println(strList);
    }
}