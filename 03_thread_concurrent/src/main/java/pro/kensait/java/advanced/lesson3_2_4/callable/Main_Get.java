package pro.kensait.java.advanced.lesson3_2_4.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main_Get {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CallableTask task = new CallableTask("foo", 7);

        try {
            System.out.println("[ Main ] starting task...");
            Future<Integer> future = executor.submit(task);
            Integer result = future.get();
            System.out.println("result => " + result);
            System.out.println("[ Main ] finish");   
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }

        executor.shutdown();
    }
}