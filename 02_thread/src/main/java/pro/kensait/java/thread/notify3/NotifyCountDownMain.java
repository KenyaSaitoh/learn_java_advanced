package pro.kensait.java.thread.notify3;

import static pro.kensait.java.thread.util.ThreadUtil.*;

public class NotifyCountDownMain {

    public static void main(String[] args) {
        ParentThread parent = new ParentThread();
        parent.start();
    }
}

/* ======================================== */
class ParentThread extends Thread {

    private int count; // アクティブな子スレッド数

    public synchronized void run() {
        System.out.println("[ ParentThread ] Start, count => " + count);

        // スレッド1を開始する
        System.out.println(
                "[ ParentThread ] Start ChildThread1, count => " + count);
        ChildThread child1 = new ChildThread(this, "1", 5000);
        child1.start();
        count++;

        // スレッド2を開始する
        System.out.println(
                "[ ParentThread ] Start ChildThread2, count => " + count);
        ChildThread child2 = new ChildThread(this, "2", 10000);
        child2.start();
        count++;

        // スレッド3を開始する
        System.out.println(
                "[ ParentThread ] Start ChildThread3, count => " + count);
        ChildThread child3 = new ChildThread(this, "3", 15000);
        child3.start();
        count++;

        //
        System.out.println("[ ParentThread ] Waiting...");
        while (0 < count) {
            try {
                wait();
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            }
        }

        // すべてのスレッドが終了したら、以下を実行する
        System.out.println("[ ParentThread ] Finish, count => " + count);
    }

    public synchronized void delChildThread() {
        // 子スレッド数の減少
        count--;
        System.out.println("[ ParentThread ] Delete childThread, count => " + count);

        //
        notify();
    }
}

/* ======================================== */
class ChildThread extends Thread {

    private ParentThread parent;
    private String property;
    private long timer;

    public ChildThread(ParentThread parent, String property, long timer) {
        this.parent = parent;
        this.property = property;
        this.timer = timer;
    }

    public void run() {
        System.out.println("[ ChildThread(" + property + ") ] Start");
        sleepAWhile(timer);
        System.out.println("[ ChildThread(" + property + ") ] Finish");
        parent.delChildThread();
    }
}