package pro.kensait.java.generics.case1;

import java.util.HashMap;
import java.util.Iterator;

public class GenericsMain12 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("personName", "John");
        map.put("age", "35");
        // map.put("age", new Integer(35));

        // Iteratorインタフェースとwhileステートメントを使った処理
        Iterator<String> i = map.values().iterator();
        while (i.hasNext()) {
            String str = i.next();
            System.out.println(str);
        }

        // 拡張forステートメントを使った処理
        for (String str : map.values()) {
            System.out.println(str);
        }
    }
}