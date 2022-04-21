package pro.kensait.java.thread.runnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableTaskMultiMain2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        RunnableTask task1 = new RunnableTask("Foo");
        RunnableTask task2 = new RunnableTask("Bar");
        RunnableTask task3 = new RunnableTask("Baz");

        try {
            Future<?> future1 = executor.submit(task1);
            Future<?> future2 = executor.submit(task2);
            future1.get();
            future2.get();
            System.out.println("[ RunnableTaskMultiMain2 ] task1 & task2 done");

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