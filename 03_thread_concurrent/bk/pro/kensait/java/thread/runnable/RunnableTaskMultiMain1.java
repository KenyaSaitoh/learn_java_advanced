package pro.kensait.java.thread.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTaskMultiMain1 {

    public static void main(String[] args) {

        // 2つのスレッドプールを持つExecutorServiceを生成する
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 3つのスレッドを生成する
        RunnableTask task1 = new RunnableTask("Foo");
        RunnableTask task2 = new RunnableTask("Bar");
        RunnableTask task3 = new RunnableTask("Baz");

        // ExecutorServiceによって3つのスレッドを起動する
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);

        // ExecutorServiceを停止する
        executor.shutdown();
    }
}