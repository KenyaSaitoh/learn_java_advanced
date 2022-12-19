package pro.kensait.java.advanced.lsn_8_1_6.wildcard.boundary_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_1 {
    public static void main(String[] args) {
        List<Bar> list1 = Arrays.asList(new Bar(), new Bar(), new Bar());

        List<Bar> list2 = new ArrayList<>();

        MyCopyUtil.process1(list1, list2);

        for (Bar bar : list2) {
            System.out.println(bar);
        }
    }
}
