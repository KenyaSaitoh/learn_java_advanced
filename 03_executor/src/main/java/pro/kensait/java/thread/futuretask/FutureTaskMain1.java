package pro.kensait.java.thread.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskMain1 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        MyCommand command = new MyCommand("1");
        FutureTask<String> futureTask = new FutureTask<String>(command);
        executor.execute(futureTask);

        try {
            String result = futureTask.get();
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