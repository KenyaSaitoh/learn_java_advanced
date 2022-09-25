package pro.kensait.java.thread.future;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pro.kensait.java.thread.util.ThreadUtil;

public class FutureMain3 {

    public static void main(String[] args) {

        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3, 5, 10, TimeUnit.SECONDS, queue);

        MyCommand command1 = new MyCommand("1");
        MyCommand command2 = new MyCommand("2");
        MyCommand command3 = new MyCommand("3");

        List<Future<String>> futureList = new CopyOnWriteArrayList<Future<String>>();

        Future<String> future1 = executor.submit(command1);
        futureList.add(future1);

        Future<String> future2 = executor.submit(command2);
        futureList.add(future2);

        Future<String> future3 = executor.submit(command3);
        futureList.add(future3);

        LOOP: while (true) {
            Iterator<Future<String>> i = futureList.iterator();
            while (i.hasNext()) {
                Future<String> future = i.next();
                if (future.isDone()) {
                    futureList.remove(future);
                    try {
                        String result = future.get();
                        System.out.println("result ---> " + result);
                    } catch (InterruptedException ie) {
                        throw new RuntimeException(ie);
                    } catch (ExecutionException ee) {
                        throw new RuntimeException(ee);
                    }
                }
            }

            long count = executor.getActiveCount();
            System.out.println("free thread count ---> " + count);
            ThreadUtil.sleepAWhile(1000);

            // ActiveCountが0になっても、Futureが残っている可能性があるので、
            // すべてのワーカの仕事が終わったかどうかには、
            // Futureの数を調べる必要がある。
            if (futureList.size() == 0) {
                executor.shutdown();
                break LOOP;
            }
        }
    }
}