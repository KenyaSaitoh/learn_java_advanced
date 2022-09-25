package pro.kensait.java.advanced.lesson3_2_4.callable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main_Done {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CallableTask task = new CallableTask("foo", 7);
        try {
            System.out.println("[ Main ] starting task...");
            Future<Integer> future = executor.submit(task);
            while (! future.isDone()) {
                System.out.println("[ Main ] do something...");
                sleepAWhile(1000);
            }
            System.out.println("[ Main ] finish");
        } finally {
            System.out.println("[ Main ] shutdown");
            executor.shutdown();
        }
    }
}