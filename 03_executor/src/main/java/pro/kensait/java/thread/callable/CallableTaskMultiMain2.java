package pro.kensait.java.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTaskMultiMain2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        CallableTask task1 = new CallableTask("A");
        CallableTask task2 = new CallableTask("AB");
        CallableTask task3 = new CallableTask("ABC");
        List<CallableTask> taskList = new ArrayList<CallableTask>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        try {
            List<Future<Integer>> futureList = executor.invokeAll(taskList);
            System.out.println("##########");
            for (Future<Integer> future : futureList) {
                Integer result = future.get();
                System.out.println("result => " + result);
            }
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        } finally {
            executor.shutdown();
        }
    }
}