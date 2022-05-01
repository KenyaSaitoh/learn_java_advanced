package pro.kensait.java.generics.wildcard.boundary1;

import java.util.Arrays;
import java.util.List;

public class GenericsMain1 {
    public static void main(String[] args) {
        HogeApi hoge = new HogeApi();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Long> list2 = Arrays.asList(1L, 2L, 3L);

        // コンパイルエラー
        // hoge.printList1(list1);

        // どっちもOK
        hoge.printList2(list1);
        hoge.printList2(list2);

        // どっちもOK
        hoge.printList3(list1);
        hoge.printList3(list2);
    }
}