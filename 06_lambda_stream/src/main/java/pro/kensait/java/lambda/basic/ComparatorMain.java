package pro.kensait.java.lambda.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Japan", "USA", "England", "France",
                "Australia");

        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println(strList);

        Collections.sort(strList, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        System.out.println(strList);
    }
}
