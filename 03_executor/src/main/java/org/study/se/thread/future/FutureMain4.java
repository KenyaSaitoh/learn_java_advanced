package org.study.se.thread.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.study.se.thread.util.ThreadUtil;

public class FutureMain4 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        MyCommand2 command = new MyCommand2("1");
        Future<String> future = executor.submit(command);

        while (!future.isDone()) {
            System.out.println("コマンドが終了するまで別の処理を続けます...");
            ThreadUtil.sleepAWhile(3000);
        }

        try {
            @SuppressWarnings("unused")
            String result = future.get();
        } catch(Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}