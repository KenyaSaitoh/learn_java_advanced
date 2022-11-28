package pro.kensait.java.thread.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import pro.kensait.java.thread.util.ThreadUtil;

public class FutureTaskMain3 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        MyCommand command = new MyCommand("1");
        FutureTask<String> futureTask = new MyFutureTask<String>(command);
        executor.execute(futureTask);

        while (!futureTask.isDone()) {
            System.out.println("コマンドが終了するまで別の処理を続けます...");
            ThreadUtil.sleepAWhile(3000);
        }

        executor.shutdown();
    }
}

/* ======================================== */
class MyFutureTask<T> extends FutureTask<T> {

    public MyFutureTask(Callable<T> callable) {
        super(callable);
    }

    public MyFutureTask(Runnable runnable, T result) {
        super(runnable, result);
    }

    protected void done() {
        System.out.println("[ MyFutureTask<T>#done ]");
        try {
            T result = this.get();
            System.out.println("result => " + result);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        }
        System.out.println();
    }

}