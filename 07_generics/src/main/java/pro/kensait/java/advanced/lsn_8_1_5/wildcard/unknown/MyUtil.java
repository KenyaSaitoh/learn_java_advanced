package pro.kensait.java.advanced.lsn_8_1_5.wildcard.unknown;

import java.util.List;

public class MyUtil {
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}