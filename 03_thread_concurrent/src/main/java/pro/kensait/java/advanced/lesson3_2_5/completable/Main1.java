package pro.kensait.java.advanced.lesson3_2_5.completable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main1 {
    public static void main(String[] args) throws Exception {
        System.out.println("[ Main ] start");
        CompletableFuture<String> future1 =
                CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                sleepAWhile(3000);
                return "Hello, World!";
            }
        });
        CompletableFuture<Integer> future2 =
                future1.thenApplyAsync(new Function<String, Integer>() {
            @Override
            public Integer apply(String param) {
                sleepAWhile(3000);
                return param.length();
            }
        });
        CompletableFuture<Void> future3 =
                future2.thenAcceptAsync(new Consumer<Integer>() {
            @Override
            public void accept(Integer param) {
                sleepAWhile(3000);
                System.out.println("length => " + param);
            }
        });
   //     try {
            //future3.get();
            System.out.println("[ Main ] finish");
       // } catch(InterruptedException | ExecutionException ex) {
       //     throw new RuntimeException(ex);
      //  }
    }
}