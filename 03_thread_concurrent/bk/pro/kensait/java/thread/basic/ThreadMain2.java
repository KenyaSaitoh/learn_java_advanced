package pro.kensait.java.thread.basic;

import static pro.kensait.java.thread.util.ThreadUtil.*;

public class ThreadMain2 {

    public static void main(String[] args) {
        // 1つ目のスレッドを生成し、起動する
        MyRunnable r1 = new MyRunnable("Foo", 10000L);
        Thread t1 = new Thread(r1);
        t1.start();

        // 2つ目のスレッドを生成し、起動する
        MyRunnable r2 = new MyRunnable("Bar", 5000L);
        Thread t2 = new Thread(r2);
        t2.start();
    }
}

/* ======================================== */
class MyRunnable implements Runnable {
    private String property;
    private long timer;
    
    public MyRunnable(String property, long timer) {
        this.property = property;
        this.timer = timer;
    }

    public void run() {
        System.out.println("[ MyRunnable ] start, property => " + property);
        sleepAWhile(timer);
        System.out.println("[ MyRunnable ] Finish, property => " + property);
    }
}