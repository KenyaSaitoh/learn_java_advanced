package pro.kensait.java.advanced.lesson4_2_2;

import java.util.stream.IntStream;

public class Main_Range {
    public static void main(String[] args) {
        IntStream.range(1, 11)
                .forEach(System.out::println);
    }
}
