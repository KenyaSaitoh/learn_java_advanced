package org.study.se.thread.future.exception;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.study.se.thread.util.ThreadUtil;

public class FutureTaskExceptionMain {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        MyCommand command = new MyCommand("1");
        MyFutureTask<String> futureTask = new MyFutureTask<String>(command);
        executor.execute(futureTask);

        while (!futureTask.isDone()) {
            System.out.println("コマンドが終了するまで別の処理を続けます...");
            ThreadUtil.sleepAWhile(3000);
        }
        Throwable exception = futureTask.getException();
        System.out.println("exception ---> " + exception);

        executor.shutdown();
    }
}

/* ======================================== */
class MyFutureTask<T> extends FutureTask<T> {

    private Throwable exception;

    public Throwable getException() {
        return exception;
    }

    @Override
    protected void setException(Throwable t) {
        super.setException(t);
        exception = t;
    }

    @Override
    protected void done() {
        System.out.println("[ MyFutureTask<T>#done ]");
        try {
            T result = this.get();
            System.out.println("result ---> " + result);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        }
        System.out.println();
    }

    public MyFutureTask(Callable<T> callable) {
        super(callable);
    }

    public MyFutureTask(Runnable runnable, T result) {
        super(runnable, result);
    }
}