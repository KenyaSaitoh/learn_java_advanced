package pro.kensait.java.generics.case0;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericsMain0 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Foo");
        list.add("Bar");
        list.add(new Integer(10));

        // Iteratorインタフェースとwhileステートメントを使った処理
        Iterator i = list.iterator();
        while (i.hasNext()) {
            String str = (String)i.next();
            System.out.println(str);
        }
    }
}