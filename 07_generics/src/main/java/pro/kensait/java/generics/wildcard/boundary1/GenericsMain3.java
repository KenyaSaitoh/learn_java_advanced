package pro.kensait.java.generics.wildcard.boundary1;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain3 {
    public static void main(String[] args) {
        FugaApi fuga = new FugaApi();

        List<Bar> list1 = new ArrayList<>();
        list1.add(new Bar()); list1.add(new Bar()); list1.add(new Bar());

        List<Bar> list2 = new ArrayList<>();

        fuga.process1(list1, list2);

        for (Foo foo : list2) {
            System.out.println(foo);
        }
    }
}

