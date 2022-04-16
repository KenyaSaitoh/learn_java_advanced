package pro.kensait.java.thread.sync2;

import pro.kensait.java.thread.util.ThreadUtil;

public class ThreadSyncMain2 {

    public static void main(String[] args) {
        // 共有オブジェクトを生成する。
        Share share = new Share();

        // 1つ目のスレッドを生成し、開始する。
        SyncThread t1 = new SyncThread(share, "Foo", 1);
        t1.start();

        // 意図的に3000ミリ秒スリープする。
        ThreadUtil.sleepAWhile(3000);

        // 2つ目のスレッドを生成し、開始する。
        SyncThread t2 = new SyncThread(share, "Bar", 2);
        t2.start();
    }
}

/* ======================================== */
class SyncThread extends Thread {

    private Share share;
    private String name;
    private int value;

    public SyncThread(Share share, String name, int value) {
        this.share = share;
        this.name = name;
        this.value = value;
    }

    public void run() {
        while (true) {
            share.setInfo(name, value);
            System.out.println(share.getName() + " / " + share.getValue());
            share.check();
            ThreadUtil.sleepAWhile(500);
        }
    }
}

/* ======================================== */
class Share {

    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // nameフィールド、valueフィールドへの更新処理。
    // この処理は「アトミックな処理」ではないため、synchronizedキーワードによって
    // このメソッドを全体を同期化する必要がある。
    public void setInfo(String name, int value) {
        this.name = name;
        ThreadUtil.sleepRandomTime(10, 90);
        this.value = value;
    }

    public void check() {
        if (!(("Foo".equals(name) && value == 1) ||
                ("Bar".equals(name) && value == 2))) {
            throw new RuntimeException("Error");
        }
    }
}