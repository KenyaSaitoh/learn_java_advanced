package pro.kensait.java.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTaskMultiMain1 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CallableTask task1 = new CallableTask("A");
        CallableTask task2 = new CallableTask("AB");
        CallableTask task3 = new CallableTask("ABC");

        try {
            Future<Integer> future1 = executor.submit(task1);
            Future<Integer> future2 = executor.submit(task2);
            Integer result1 = future1.get();
            Integer result2 = future2.get();
            System.out.println(result1);
            System.out.println(result2);

            Future<Integer> future3 = executor.submit(task3);
            Integer result3 = future3.get();
            System.out.println(result3);

        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        } finally {
            executor.shutdown();
        }
    }
}