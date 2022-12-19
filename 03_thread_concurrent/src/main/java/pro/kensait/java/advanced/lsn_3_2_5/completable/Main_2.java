package pro.kensait.java.advanced.lsn_3_2_5.completable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main_2 {
    public static void main(String[] args) throws Exception {
        System.out.println("[ Main ] start");
        CompletableFuture<Void> future =
                CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                sleepAWhile(3000);
                return "Hello, World!";
            }
        }).thenApplyAsync(new Function<String, Integer>() {
            @Override
            public Integer apply(String param) {
                sleepAWhile(3000);
                return param.length();
            }
        }).thenAcceptAsync(new Consumer<Integer>() {
            @Override
            public void accept(Integer param) {
                sleepAWhile(3000);
                System.out.println("length => " + param);
            }
        });
        try {
            future.get();
            System.out.println("[ Main ] finish");
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }
    }
}