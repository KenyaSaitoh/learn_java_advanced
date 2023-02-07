package pro.kensait.java.advanced.lsn_7_1_4.extend;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {
    static <E extends Number> List<E> createSameElemList(E element) {
        List<E> list = new ArrayList<>();
        int count = element.intValue();
        for (int i = 0; i < count; i++) {
            list.add(element);
        }
        return list;
    }
}