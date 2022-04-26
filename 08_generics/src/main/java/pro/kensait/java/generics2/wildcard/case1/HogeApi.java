package pro.kensait.java.generics2.wildcard.case1;

import java.util.List;

public class HogeApi {

    public void printList1(List<Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }

    public void printList2(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}