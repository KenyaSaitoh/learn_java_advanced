package pro.kensait.java.thread.countdown;

public class NotifyCountDownMain {

    public static void main(String[] args) {
        System.out.println("[ NotifyMain2 ] Start...");
        AdminThread admin = new AdminThread();
        admin.start();
        System.out.println("[ NotifyMain2 ] End");
    }
}

/* ======================================== */
class AdminThread extends Thread {

    int count = 0; // アクティブな子スレッド数

    public synchronized void run() {
        System.out.println("[ AdminThread ] Start, count = " + count);

        // スレッド1を起動
        System.out.println("[ AdminThread ] Start ChildThread1, count = " + count);
        ChildThread child1 = new ChildThread(this, 5000);
        child1.start();
        count++;

        // スレッド2を起動
        System.out.println("[ AdminThread ] Start ChildThread2, count = " + count);
        ChildThread child2 = new ChildThread(this, 10000);
        child2.start();
        count++;

        // スレッド3を起動
        System.out.println("[ AdminThread ] Start ChildThread3, count = " + count);
        ChildThread child3 = new ChildThread(this, 15000);
        child3.start();
        count++;

        //
        System.out.println("[ AdminThread ] Waiting...");
        while (0 < count) {
            try {
                wait();
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            }
        }

        // すべてのスレッドが終了してから、実行すべき処理
        System.out.println("[ AdminThread ] Done, count = " + count);
    }

    public synchronized void delChildThread() {
        // 子スレッド数の減少
        count--;
        System.out.println("[ AdminThread ] delChildThread, count = " + count);

        //
        notify();
    }
}

/* ======================================== */
class ChildThread extends Thread {

    AdminThread admin;
    int timer;

    public ChildThread(AdminThread admin, int timer) {
        this.admin = admin;
        this.timer = timer;
    }

    public void run() {
        System.out.println(
                "[ ChildThread(" + Thread.currentThread().getName() + ") ] Start...");

        try {
            Thread.sleep(timer);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        System.out.println(
                "[ ChildThread(" + Thread.currentThread().getName() + ") ] Done");
        admin.delChildThread();
    }
}