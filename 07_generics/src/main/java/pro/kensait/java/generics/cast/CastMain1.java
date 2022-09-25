package pro.kensait.java.generics.cast;

import java.util.Date;

public class CastMain1 {
    public static void main(String[] args) throws Exception {
        Class<Date> clazz = Date.class;
        Date date = clazz.getDeclaredConstructor().newInstance();
        System.out.println("Date ---> " + date);
    }
}