package pro.kensait.java.advanced.lsn_4_2_4.aggregate;

import java.util.Arrays;
import java.util.List;

public class Main_Count {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long count = list.stream()
                .filter(x -> x % 2 == 0)
                .count();
        System.out.println(count);
    }
}