package pro.kensait.java.generics2.wildcard.case2;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain4 {
    public static void main(String[] args) {
        FugaApi fuga = new FugaApi();

        List<Baz> list1 = new ArrayList<>();
        list1.add(new Baz()); list1.add(new Baz()); list1.add(new Baz());

        List<Foo> list2 = new ArrayList<>();

        // BarまたはBarのサブクラスのリストを、BarまたはBarのスーパークラスのリストに
        // コピーする
        fuga.process2(list1, list2);

        for (Foo foo : list2) {
            System.out.println(foo);
        }
    }
}
