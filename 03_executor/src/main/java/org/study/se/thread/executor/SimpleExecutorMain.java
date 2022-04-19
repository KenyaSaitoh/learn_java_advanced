package org.study.se.thread.executor;

import java.util.concurrent.Executor;

public class SimpleExecutorMain {

    public static void main(String[] args) {
        MyCommand command = new MyCommand("1");
        MyExecutor executor = new MyExecutor();
        executor.execute(command);
    }
}

/* ======================================== */
class MyExecutor implements Executor {

    public void execute(Runnable command) {
        Thread t = new Thread(command);
        t.start();
    }
}