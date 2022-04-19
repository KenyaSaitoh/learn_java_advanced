package pro.kensait.java.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTaskSingleMain {

    public static void main(String[] args) throws Exception {

        CallableTask task = new CallableTask("Foo");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(task);

        try {
            Integer result = future.get(); // CallableTaskで例外が発生していた場合はこの時点で受け取れる
            System.out.println("result ---> " + result);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        } finally {
            executor.shutdown();
        }
    }
}