package pro.kensait.java.thread.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTaskMultiMain1 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        RunnableTask task1 = new RunnableTask("A");
        RunnableTask task2 = new RunnableTask("AB");
        RunnableTask task3 = new RunnableTask("ABC");

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);

        executor.shutdown();
    }
}