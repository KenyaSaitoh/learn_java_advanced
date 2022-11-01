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
        System.out.println("[ ParentThread ] start");

        // 自身への参照を持つ子スレッドを生成し、起動する
        System.out.println("[ ParentThread ] start ChildThread");
        ChildThread child = new ChildThread(this);
        child.start();

        try {
            wait();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        System.out.println("[ ParentThread ] finish");
    }
}

/* ======================================== */
class ChildThread extends Thread {

    private ParentThread parent;

    public ChildThread(ParentThread parent) {
        this.parent = parent;
    }

    public void run() {
        System.out.println("[ ChildThread ] start");
        sleepAWhile(5000);

        synchronized(parent) {
            // ウェイトセットに入ったスレッド（1つだけ）に通知を送る
            parent.notify();
            System.out.println("[ ChildThread ] finish");
        }
    }
}