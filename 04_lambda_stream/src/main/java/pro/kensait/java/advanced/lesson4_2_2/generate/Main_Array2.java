package pro.kensait.java.advanced.lesson4_2_2.generate;

import java.util.Arrays;

public class Main_Array2 {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(intArray)
                .forEach(System.out::println);
    }
}
