package pro.kensait.java.advanced.lesson3_2_4.invoke;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import pro.kensait.java.advanced.lesson3_2_4.callable.CallableTask;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CallableTask fooTask = new CallableTask("foo", 7);
        CallableTask barTask = new CallableTask("bar", 10);
        CallableTask bazTask = new CallableTask("baz", 5);
        List<CallableTask> taskList = new ArrayList<CallableTask>();
        taskList.add(fooTask);
        taskList.add(barTask);
        taskList.add(bazTask);

        try {
            System.out.println("[ Main ] starting all tasks...");
            List<Future<Integer>> futureList = executor.invokeAll(taskList);
            for (Future<Integer> future : futureList) {
                Integer result = future.get();
                System.out.println("result => " + result);
            }
            System.out.println("[ Main ] finish");
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        } finally {
            executor.shutdown();
        }
    }
}