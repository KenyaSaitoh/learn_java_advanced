package pro.kensait.java.thread.deadlock;

public class DeadlockMain {

    private Share shareX;
    private Share shareY;

    public static void main(String[] args) {
        (new DeadlockMain()).executeTask();
    }

    private void executeTask() {
        shareX = new Share(0); // 初期値が0の共有オブジェクトを生成
        shareY = new Share(10000); // 初期値が10000の共有オブジェクトを生成


        DeadlockThread thread0 = new DeadlockThread(shareX, shareY, 5); // カウンタが5のスレッドを生成
        thread0.start(); // スレッド0を起動

        try {
            Thread.sleep(1000); // 1秒間スリープ
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }


        DeadlockThread thread1 = new DeadlockThread(shareY, shareX, 7); // カウンタが7のスレッドを生成
        thread1.start(); // スレッド0から1秒遅れてスレッド1を起動
    }
}

/* ======================================== */
class DeadlockThread extends Thread {

    private int count; // カウンタ
    private Share share1; // 共有オブジェクト1をフィールドとして保持
    private Share share2; // 共有オブジェクト2をフィールドとして保持

    public DeadlockThread(Share share1, Share share2, int count) {
        this.share1 = share1;
        this.share2 = share2;
        this.count = count;
    }

    public void run() {
        String threadName = this.getName();
        while (true) {
            synchronized (share1) { // まず共有オブジェクト1をロック
                System.out.println("[" + threadName + " / ShareObject = 1] Before Add Count ---> " + share1.getValue());
                share1.addCount(count); // スレッドが保持しているカウンタで共有オブジェクト1の値を更新
                System.out.println("[" + threadName + " / ShareObject = 1] Commit Add Count =======> "
                        + share1.getValue());
                synchronized (share2) { // 共通オブジェクト1にロックをかけたまま、共有オブジェクト2をロック
                    System.out.println("[" + threadName + " / ShareObject = 2] Before Add Count ---> "
                            + share2.getValue());
                    share2.addCount(count); // スレッドが保持しているカウンタで共有オブジェクト2の値を更新
                    System.out.println("[" + threadName + " / ShareObject = 2] Commit Add Count =======> "
                            + share2.getValue());
                }
            }
        }
    }
}

/* ======================================== */
class Share {

    private int value;

    public Share(int value) {
        this.value = value;
    }

    public void addCount(int count) {
        int value = this.value;
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        value = value + count;
        this.value = value; // 引数として渡されたカウンタをプラスして、値を更新
    }

    public int getValue() {
        return value;
    }
}