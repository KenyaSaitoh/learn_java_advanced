package pro.kensait.java.generics.case1;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericsMain11 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Foo");
        list.add("Bar");
        // list.add(new Integer(10));

        // Iteratorインタフェースとwhileステートメントを使った処理
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            String str = i.next();
            System.out.println(str);
        }

        // 拡張forステートメントを使った処理
        for (String str : list) {
            System.out.println(str);
        }
    }
}