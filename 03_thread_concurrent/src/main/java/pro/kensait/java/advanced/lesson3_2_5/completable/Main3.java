package pro.kensait.java.advanced.lesson3_2_5.completable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main3 {
    public static void main(String[] args) throws Exception {
        System.out.println("[ Main ] start");
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            sleepAWhile(3000);
            return "Hello, World!";
        }).thenApplyAsync((String param) -> {
            sleepAWhile(3000);
            return param.length();
        }).thenAcceptAsync((Integer param) -> {
            sleepAWhile(3000);
            System.out.println("length => " + param);
        });
        try {
            future.get();
            System.out.println("[ Main ] finish");
        } catch (InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }
    }
}