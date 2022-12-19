package pro.kensait.java.advanced.lsn_4_2_2;

import java.util.Arrays;

public class Main_Array_2 {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(intArray)
                .forEach(System.out::println);
    }
}
