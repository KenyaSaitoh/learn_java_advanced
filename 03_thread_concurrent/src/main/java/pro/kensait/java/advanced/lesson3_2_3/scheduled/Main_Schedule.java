package pro.kensait.java.advanced.lesson3_2_3.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main_Schedule {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        RunnableTask task = new RunnableTask();
        try {
            System.out.println("[ Main ] starting task...");
            executor.schedule(task, 5L, TimeUnit.SECONDS);
            System.out.println("[ Main ] finish");
        } finally {
            // ScheduledExecutorServiceは、Runnableの投入を待ち続けるため、
            // shutdownを呼び出さないと、プログラムが終了しない
            System.out.println("[ Main ] shutdown");
            executor.shutdown();
        }
    }
}