package pro.kensait.java.advanced.lesson8_1_2.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(3);
        Collections.sort(list, new StrLengthComparator1());
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}
