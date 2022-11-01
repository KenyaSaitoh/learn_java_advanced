package pro.kensait.java.advanced.lesson4_1_1.comparator;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}