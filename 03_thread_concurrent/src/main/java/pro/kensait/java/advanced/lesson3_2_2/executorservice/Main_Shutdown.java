package pro.kensait.java.advanced.lesson3_2_2.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main_Shutdown {
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
            System.out.println("[ Main ] finish");
        } finally {
            System.out.println("[ Main ] shutdown");
            executor.shutdown();
        }
    }
}