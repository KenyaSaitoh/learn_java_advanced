package pro.kensait.java.advanced.lesson8_1_2.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Japan");
        list.add("USA");
        list.add("France");
        Collections.sort(list, new StrLengthComparator2());
        for (String value : list) {
            System.out.println(value);
        }
    }
}
