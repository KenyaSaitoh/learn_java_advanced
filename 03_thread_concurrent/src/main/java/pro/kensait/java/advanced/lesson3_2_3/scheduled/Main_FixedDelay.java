package pro.kensait.java.advanced.lesson3_2_3.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main_FixedDelay {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        RunnableTask task = new RunnableTask();
        System.out.println("[ Main ] starting task...");
        executor.scheduleWithFixedDelay(task, 2L, 5L, TimeUnit.SECONDS);
        System.out.println("[ Main ] finish");
    }
}