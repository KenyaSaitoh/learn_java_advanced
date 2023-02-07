package pro.kensait.java.advanced.lsn_7_1_6.boundary_3;

import java.util.List;

public class MyCopyUtil_2 {
    public static void process(List<? extends Bar> src,
            List<? super Bar> dest) {
        for (Bar bar : src) {
            dest.add(bar);
        }
    }
}