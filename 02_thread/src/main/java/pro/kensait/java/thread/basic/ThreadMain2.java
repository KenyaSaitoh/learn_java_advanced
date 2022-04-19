package pro.kensait.java.thread.basic;

import static pro.kensait.java.thread.util.ThreadUtil.sleepAWhile;

public class ThreadMain2 {

    public static void main(String[] args) {
        // 1つ目のスレッドを生成し、開始する
        MyRunnable r1 = new MyRunnable("Foo", 10000L);
        Thread t1 = new Thread(r1);
        t1.start();

        // 2つ目のスレッドを生成し、開始する
        MyRunnable r2 = new MyRunnable("Bar", 5000L);
        Thread t2 = new Thread(r2);
        t2.start();
    }
}

/* ======================================== */
class MyRunnable implements Runnable {
    private String name;
    private long timer;
    
    public MyRunnable(String name, long timer) {
        this.name = name;
        this.timer = timer;
    }

    public void run() {
        System.out.println("[ MyRunnable#run ] Start, name => " + name);
        sleepAWhile(timer);
        System.out.println("[ MyRunnable#run ] Finish, name => " + name);
    }
}