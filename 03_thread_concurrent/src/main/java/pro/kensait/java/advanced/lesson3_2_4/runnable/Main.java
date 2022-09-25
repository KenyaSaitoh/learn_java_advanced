package pro.kensait.java.advanced.lesson3_2_4.runnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        RunnableTask fooTask = new RunnableTask("foo", 7);
        RunnableTask barTask = new RunnableTask("bar", 10);
        RunnableTask bazTask = new RunnableTask("baz", 5);

        try {
            Future<?> fooFuture = executor.submit(fooTask);
            Future<?> barFuture = executor.submit(barTask);
            fooFuture.get();
            barFuture.get();
            System.out.println("[ Main ] foo & bar finish ");
            Future<?> bazFuture = executor.submit(bazTask);
            bazFuture.get();
            System.out.println("[ Main ] baz finish");
            System.out.println("[ Main ] finish");
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        } finally {
            System.out.println("[ Main ] shutdown");
            executor.shutdown();
        }
    }
}