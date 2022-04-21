package pro.kensait.java.thread.runnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableTaskMultiMain2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        RunnableTask task1 = new RunnableTask("A");
        RunnableTask task2 = new RunnableTask("AB");
        RunnableTask task3 = new RunnableTask("ABC");

        try {
            Future<?> future1 = executor.submit(task1);
            Future<?> future2 = executor.submit(task2);
            future1.get();
            future2.get();
            System.out.println("Task1 & 2 is done!");

            executor.submit(task3);

        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        } finally {
            executor.shutdown();
        }
    }
}