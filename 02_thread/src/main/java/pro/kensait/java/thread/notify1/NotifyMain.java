package pro.kensait.java.thread.notify1;

import static pro.kensait.java.thread.util.ThreadUtil.sleepAWhile;

public class NotifyMain {

    public static void main(String[] args) {
        ParentThread parent = new ParentThread();
        parent.start();
    }
}

/* ======================================== */
class ParentThread extends Thread {

    public synchronized void run() {
        System.out.println("[ ParentThread ] Start");

        // 子スレッドを起動する
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

    public synchronized void notifyFromChild() {
        notify();
    }
}

/* ======================================== */
class ChildThread extends Thread {

    private ParentThread admin;

    public ChildThread(ParentThread admin) {
        this.admin = admin;
    }

    public void run() {
        System.out.println("[ ChildThread ] Start");
        sleepAWhile(5000);

        //
        synchronized(admin) {
            admin.notify();
            System.out.println("[ ChildThread ] Finish");
        }

        // admin.notify呼び出しの代わりに、以下の呼び出しでもOK。
        // いずれも、adminオブジェクトの中でsynchronizedがかかっている必要あり。
        // notifyFromChild();
    }
}