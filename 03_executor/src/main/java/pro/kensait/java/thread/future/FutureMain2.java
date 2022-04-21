package pro.kensait.java.thread.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import pro.kensait.java.thread.util.ThreadUtil;

public class FutureMain2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        MyCommand command = new MyCommand("1");
        Future<String> future = executor.submit(command);

        while (!future.isDone()) {
            System.out.println("コマンドが終了するまで別の処理を続けます...");
            ThreadUtil.sleepAWhile(3000);
        }

        executor.shutdown();
    }
}