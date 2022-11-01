package pro.kensait.java.advanced.lesson4_2_2.generate;

import java.util.stream.Stream;

public class Main_Iterate {
    public static void main(String[] args) {
        Stream.iterate(10, x -> x * 2)
                .limit(20)
                .forEach(System.out::println);
    }
}
