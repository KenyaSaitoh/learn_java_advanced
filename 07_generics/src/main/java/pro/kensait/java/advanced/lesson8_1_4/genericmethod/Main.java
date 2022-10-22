package pro.kensait.java.advanced.lesson8_1_4.genericmethod;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strList = MyUtil.createSameElemList("Hello", 10);
        System.out.println(strList);
    }
}