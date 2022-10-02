package pro.kensait.java.advanced.lesson3_2_4.runnable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        RunnableTask fooTask = new RunnableTask("foo", 8);

        try {
            Future<?> fooFuture = executor.submit(fooTask);
            fooFuture.get();
            System.out.println("[ Main ] foo finish ");
            doSomething(3); // 3秒間何かをする
            System.out.println("[ Main ] finish");
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }

        executor.shutdown();
    }
}