package pro.kensait.java.advanced.lesson4_2_2.generate;

import java.util.stream.Stream;

public class Main_Of {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .forEach(System.out::println);
    }
}
