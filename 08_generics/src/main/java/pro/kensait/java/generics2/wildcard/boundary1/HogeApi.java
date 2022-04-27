package pro.kensait.java.generics2.wildcard.boundary1;

import java.util.List;

public class HogeApi {

    public void printList1(List<Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }

    public <T extends Number> void printList2(List<T> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }

    public void printList3(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }
}