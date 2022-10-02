package pro.kensait.java.advanced.lesson3_2_2.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main_Await {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        RunnableTask fooTask = new RunnableTask("foo", 8);
        RunnableTask barTask = new RunnableTask("bar", 15);
        RunnableTask bazTask = new RunnableTask("baz", 5);
        System.out.println("[ Main ] starting all threads...");
        executor.submit(fooTask);
        executor.submit(barTask);
        executor.submit(bazTask);
        System.out.println("[ Main ] shutdown");
        executor.shutdown();
        try {
            if (! executor.awaitTermination(12L, TimeUnit.SECONDS)) {
                System.out.println("[ Main ] shutdown now");
                executor.shutdownNow();
            }
        } catch(InterruptedException ie) {
            executor.shutdownNow();
        }
        System.out.println("[ Main ] finish");
    }
}