package pro.kensait.java.thread.future.exception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExceptionMain {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        MyCommand command = new MyCommand("1");
        Future<String> future = executor.submit(command);

        try {
            String result = future.get();
            System.out.println("result ---> " + result);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        } catch(Exception e) {
            System.out.println("mainメソッドで、例外をキャッチしました。");
        } finally {
            executor.shutdown();
        }
    }
}