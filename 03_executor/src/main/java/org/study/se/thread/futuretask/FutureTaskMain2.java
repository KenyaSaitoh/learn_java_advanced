package org.study.se.thread.futuretask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.study.se.thread.util.ThreadUtil;

public class FutureTaskMain2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        MyCommand command = new MyCommand("1");
        FutureTask<String> futureTask = new FutureTask<String>(command);
        executor.execute(futureTask);

        while (!futureTask.isDone()) {
            System.out.println("コマンドが終了するまで別の処理を続けます...");
            ThreadUtil.sleepAWhile(3000);
        }

        executor.shutdown();
    }
}