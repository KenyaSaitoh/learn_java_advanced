package pro.kensait.java.advanced.lesson3_2_4.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main_Multi {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CallableTask fooTask = new CallableTask("foo", 8);
        CallableTask barTask = new CallableTask("bar", 15);
        CallableTask bazTask = new CallableTask("baz", 5);

        try {
            System.out.println("[ Main ] starting foo & bar...");
            Future<Integer> fooFuture = executor.submit(fooTask);
            Future<Integer> barFuture = executor.submit(barTask);
            Integer fooResult = fooFuture.get();
            Integer barResult = barFuture.get();
            System.out.println("[ Main ] foo, result => " + fooResult);
            System.out.println("[ Main ] bar, result => " + barResult);
            System.out.println("[ Main ] starting baz...");
            Future<Integer> bazFuture = executor.submit(bazTask);
            Integer bazResult = bazFuture.get();
            System.out.println("[ Main ] baz, result => " + bazResult);
            System.out.println("[ Main ] finish");
        } catch (InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }

        executor.shutdown();
    }
}