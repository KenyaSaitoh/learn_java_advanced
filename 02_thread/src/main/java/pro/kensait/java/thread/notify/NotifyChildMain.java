package pro.kensait.java.thread.notify;

import static pro.kensait.java.thread.util.ThreadUtil.*;

public class NotifyChildMain {

    public static void main(String[] args) {
        ParentThread parent = new ParentThread();
        parent.start();
    }
}

/* ======================================== */
class ParentThread extends Thread {

    public synchronized void run() {
        System.out.println("[ ParentThread ] Start");

        // 自身への参照を持つ子スレッドを生成し、開始する
        System.out.println("[ ParentThread ] Start ChildThread");
        ChildThread child = new ChildThread(this);
        child.start();

        try {
            wait();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        System.out.println("[ ParentThread ] Finish");
    }
}

/* ======================================== */
class ChildThread extends Thread {

    private ParentThread parent;

    public ChildThread(ParentThread parent) {
        this.parent = parent;
    }

    public void run() {
        System.out.println("[ ChildThread ] Start");
        sleepAWhile(5000);

        synchronized(parent) {
            // ウェイトセットに入ったスレッド（1つだけ）に通知を送る
            parent.notify();
            System.out.println("[ ChildThread ] Finish");
        }
    }
}