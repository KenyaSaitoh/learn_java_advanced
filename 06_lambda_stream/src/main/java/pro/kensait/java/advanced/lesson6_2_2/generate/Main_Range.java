package pro.kensait.java.advanced.lesson6_2_2.generate;

import java.util.stream.IntStream;

public class Main_Range {
    public static void main(String[] args) {
        IntStream.range(1, 11)
                .forEach(System.out::println);
    }
}
