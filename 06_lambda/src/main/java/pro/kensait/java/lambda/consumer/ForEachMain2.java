package pro.kensait.java.lambda.consumer;

import java.util.Arrays;
import java.util.List;

public class ForEachMain2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.forEach(x -> System.out.println(x));
    }
}