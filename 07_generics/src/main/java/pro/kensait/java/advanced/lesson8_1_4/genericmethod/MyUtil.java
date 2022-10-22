package pro.kensait.java.advanced.lesson8_1_4.genericmethod;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {
    static <E> List<E> createSameElemList(E element, int count) {
        List<E> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(element);
        }
        return list;
    }
}