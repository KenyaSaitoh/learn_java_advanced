package pro.kensait.java.thread.sync1;

import pro.kensait.java.thread.util.ThreadUtil;

public class ThreadSyncMain1 {

    public static void main(String[] args) {
        // 共有オブジェクトを生成する。
        Share share = new Share();

        // 1つ目のスレッドを生成し、開始する。
        SyncThread t1 = new SyncThread(share, 5);
        t1.start();

        // 意図的に3000ミリ秒スリープする。
        ThreadUtil.sleepAWhile(3000);

        // 1つ目のスレッドを生成し、開始する。
        SyncThread t2 = new SyncThread(share, 7);
        t2.start();
    }
}

/* ======================================== */
class SyncThread extends Thread {

    private Share share;
    private int value;

    public SyncThread(Share share, int value) {
        this.share = share;
        this.value = value;
    }

    public void run() {
        String name = this.getName();
        while (true) {
            System.out.println("(" + name + ") Before Add Count ---> " +
                    share.getCount());
            share.addCount(value);
            System.out.println("(" + name + ") After Add Count =======> " +
                    share.getCount());
            ThreadUtil.sleepAWhile(1000);
        }
    }
}

/* ======================================== */
class Share {

    private int count = 0;

    // countフィールドへの更新処理。
    // この処理は「アトミックな処理」ではないため、synchronizedキーワードによって
    // このメソッドを全体を同期化する必要がある。
    public void addCount(int x) {
        int y = this.count;
        ThreadUtil.sleepRandomTime(10, 90);
        y = y + x;
        this.count = y;
    }

    public int getCount() {
        return count;
    }
}