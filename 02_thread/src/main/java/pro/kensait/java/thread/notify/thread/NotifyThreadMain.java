package pro.kensait.java.thread.notify.thread;

public class NotifyThreadMain {

    public static void main(String[] args) {
        System.out.println("[ NotifyMain ] Start...");
        AdminThread admin = new AdminThread();
        admin.start();
        System.out.println("[ NotifyMain ] End");
    }
}

/* ======================================== */
class AdminThread extends Thread {

    public synchronized void run() {
        System.out.println("[ AdminThread ] Start...");

        // 子スレッドを起動する
        System.out.println("[ AdminThread ] Start ChildThread");
        ChildThread child = new ChildThread(this);
        child.start();

        try {
            wait();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        System.out.println("[ AdminThread ] Done");
    }

    public synchronized void notifyFromChild() {
        notify();
    }
}

/* ======================================== */
class ChildThread extends Thread {

    AdminThread admin;

    public ChildThread(AdminThread admin) {
        this.admin = admin;
    }

    public void run() {
        System.out.println("[ ChildThread ] Start...");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //
        synchronized(admin) {
            admin.notify();
            System.out.println("[ ChildThread ] Done");
        }

        // admin.notify呼び出しの代わりに、以下の呼び出しでもOK。
        // いずれも、adminオブジェクトの中でsynchronizedがかかっている必要あり。
        // notifyFromChild();
    }
}