package pro.kensait.java.advanced.lesson8_1_5.wildcard.unknown;

import java.util.List;

public class MyUtil {
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}