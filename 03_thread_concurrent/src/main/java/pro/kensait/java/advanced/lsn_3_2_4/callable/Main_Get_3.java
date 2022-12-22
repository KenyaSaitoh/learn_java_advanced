package pro.kensait.java.advanced.lsn_3_2_4.callable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main_Get_3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CallableTask task = new CallableTask("foo", 8);

        try {
            System.out.println("[ Main ] starting task...");
            Future<Integer> future = executor.submit(task);
            doSomething(3);
            Integer result = future.get();
            System.out.println("result => " + result);
            System.out.println("[ Main ] finish");   
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }
        executor.shutdown();
    }
}