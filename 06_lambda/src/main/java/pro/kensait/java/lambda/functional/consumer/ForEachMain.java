package pro.kensait.java.lambda.functional.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// Consumerを引数に受け取る既存API
public class ForEachMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // コンソールに出力する（Consumerオブジェクトを渡す）
        list.forEach(new Consumer<Integer>() {
            public void accept(Integer x) {
                System.out.println(x);
            }
        });

        // コンソールに出力する（ラムダ式を渡す）
        list.forEach(x -> System.out.println(x));

        // コンソールに出力する（メソッド参照を渡す）
        list.forEach(System.out::println);
    }
}