package pro.kensait.java.thread.notify3;

import static pro.kensait.java.thread.util.ThreadUtil.sleepAWhile;

public class NotifyCountDownMain {

    public static void main(String[] args) {
        ParentThread parent = new ParentThread();
        parent.start();
    }
}

/* ======================================== */
class ParentThread extends Thread {

    int count = 0; // アクティブな子スレッド数

    public synchronized void run() {
        System.out.println("[ ParentThread ] Start, count => " + count);

        // スレッド1を起動する
        System.out.println(
                "[ ParentThread ] Start ChildThread1, count => " + count);
        ChildThread child1 = new ChildThread(this, "1", 5000);
        child1.start();
        count++;

        // スレッド2を起動する
        System.out.println(
                "[ ParentThread ] Start ChildThread2, count => " + count);
        ChildThread child2 = new ChildThread(this, "2", 10000);
        child2.start();
        count++;

        // スレッド3を起動する
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

        // すべてのスレッドが終了してから、実行すべき処理
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
    private String name;
    private long timer;

    public ChildThread(ParentThread parent, String name, long timer) {
        this.parent = parent;
        this.name = name;
        this.timer = timer;
    }

    public void run() {
        System.out.println("[ ChildThread(" + name + ") ] Start");
        sleepAWhile(timer);
        System.out.println("[ ChildThread(" + name + ") ] Finish");
        parent.delChildThread();
    }
}