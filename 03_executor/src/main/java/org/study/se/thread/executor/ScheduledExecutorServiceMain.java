package org.study.se.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceMain {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

        try {
            MyCommand command1 = new MyCommand("1");
            executor.schedule(command1, 2L, TimeUnit.SECONDS);

            MyCommand command2 = new MyCommand("2");
            executor.schedule(command2, 4L, TimeUnit.SECONDS);

            MyCommand command3 = new MyCommand("3");
            executor.schedule(command3, 6L, TimeUnit.SECONDS);

            MyCommand command4 = new MyCommand("4");
            executor.schedule(command4, 8L, TimeUnit.SECONDS);
        } finally {
            // ScheduledExecutorServiceは、Runnableの投入を待ち続けるため、
            // shutdownを呼び出さないと、プログラムが終了しない。
            executor.shutdown();
        }
    }
}