package org.study.se.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorMain1 {

    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        //
        MyThread thread1 = new MyThread("Foo");

        service.schedule(thread1, 5000, TimeUnit.MILLISECONDS);
    }
}

/* ======================================== */
class MyThread extends Thread {

    String param;

    public MyThread(String param) {
        this.param = param;
    }

    public void run() {
        System.out.println("MyThread Running...");
    }
}
