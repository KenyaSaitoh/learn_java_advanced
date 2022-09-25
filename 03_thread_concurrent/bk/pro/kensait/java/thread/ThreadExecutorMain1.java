package pro.kensait.java.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorMain1 {

    public static void main(String[] args) {

        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3, 5, 10, TimeUnit.SECONDS, queue);

        MyThread2 thread1 = new MyThread2(1);
        executor.execute(thread1);
        MyThread2 thread2 = new MyThread2(2);
        executor.execute(thread2);
        MyThread2 thread3 = new MyThread2(3);
        executor.execute(thread3);
        MyThread2 thread4 = new MyThread2(4);
        executor.execute(thread4);
        MyThread2 thread5 = new MyThread2(5);
        executor.execute(thread5);
        MyThread2 thread6 = new MyThread2(6);
        executor.execute(thread6);

        try {
            Thread.sleep(10000);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        executor.shutdown();
    }
}

/* ======================================== */
class MyThread2 extends Thread {

    int value;

    public MyThread2(int value) {
        this.value = value;
    }

    public void run() {
        System.out.println("MyThread Running...(" + value + ")");
    }
}
