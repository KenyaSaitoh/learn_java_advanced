package pro.kensait.java.generics.case2;

import java.util.Date;

public class GenericsMain21 {
    public static void main(String[] args) throws Exception {
        Class<Date> clazz = Date.class;
        Date date = clazz.newInstance();
        System.out.println("Date ---> " + date);
    }
}
