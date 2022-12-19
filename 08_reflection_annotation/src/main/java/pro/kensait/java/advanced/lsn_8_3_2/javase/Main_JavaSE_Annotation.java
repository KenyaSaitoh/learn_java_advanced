package pro.kensait.java.advanced.lsn_8_3_2.javase;

import java.util.ArrayList;
import java.util.List;

public class Main_JavaSE_Annotation {
    @SuppressWarnings("unused")
    private int tmp1 = 0;

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int tmp2 = 0;

        @SuppressWarnings("rawtypes")
        List list = new ArrayList();
        System.out.println(list);

        Integer val1 = null;
        @SuppressWarnings({ "unused", "static-access" })
        int val2 = val1.parseInt("1234");
    }
}