package pro.kensait.java.thread.basic;

import static pro.kensait.java.thread.util.ThreadUtil.sleepAWhile;

public class ThreadMain1 {

    public static void main(String[] args) {
        // 1つ目のスレッドを生成し、開始する
        MyThread t1 = new MyThread("Foo", 10000L);
        t1.start();

        // 2つ目のスレッドを生成し、開始する
        MyThread t2 = new MyThread("Bar", 5000L);
        t2.start();
    }
}

/* ======================================== */
class MyThread extends Thread {
    private String name;
    private long timer;
    
    public MyThread(String name, long timer) {
        this.name = name;
        this.timer = timer;
    }

    public void run() {
        System.out.println("[ MyThread#run ] Start, name => " + name);
        sleepAWhile(timer);
        System.out.println("[ MyThread#run ] Finish, name => " + name);
    }
}