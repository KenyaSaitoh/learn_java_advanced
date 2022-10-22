package pro.kensait.java.advanced.lesson8_1_6.wildcard.boundary3;

import java.util.List;

public class MyCopyUtil {
    public static void process1(List<Bar> src, List<Bar> dest) {
        for (Bar bar : src) {
            dest.add(bar);
        }
    }

    public static void process2(List<? extends Bar> src,
            List<? super Bar> dest) {
        for (Bar bar : src) {
            dest.add(bar);
        }
    }
}