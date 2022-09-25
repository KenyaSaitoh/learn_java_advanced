package pro.kensait.java.advanced.lesson3_2_2.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main_Await {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        RunnableTask fooTask = new RunnableTask("foo", 7);
        RunnableTask barTask = new RunnableTask("bar", 10);
        RunnableTask bazTask = new RunnableTask("baz", 5);
        try {
            System.out.println("[ Main ] starting all threads...");
            executor.submit(fooTask);
            executor.submit(barTask);
            executor.submit(bazTask);
            executor.awaitTermination(8L, TimeUnit.SECONDS);
            System.out.println("[ Main ] finish");
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        } finally {
            System.out.println("[ Main ] shutdown");
            executor.shutdown();
        }
    }
}