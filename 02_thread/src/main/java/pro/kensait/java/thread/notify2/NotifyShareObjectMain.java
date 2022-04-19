package pro.kensait.java.thread.notify2;

import static pro.kensait.java.thread.util.ThreadUtil.sleepAWhile;

public class NotifyShareObjectMain {

    public static void main(String[] args) {
        // 共有オブジェクトを生成する
        SharedObject share = new SharedObject(0);

        // 1つ目のスレッド（ReadThread）を生成し、開始する
        ReadThread t1 = new ReadThread(share);
        t1.start();

        // 2つ目のスレッド（WriteThread）を生成し、開始する
        WriteThread t2 = new WriteThread(share);
        t2.start();
    }
}

/* ======================================== */
class ReadThread extends Thread {

    private SharedObject share;

    public ReadThread(SharedObject share) {
        this.share = share;
    }

    public void run() {
        System.out.println("[ ReadThread#run ] Start");
        int result = share.readProcess();
        System.out.println("[ ReadThread#run ] Finish, result => " + result);
    }
}

/* ======================================== */
class WriteThread extends Thread {

    private SharedObject share;

    public WriteThread(SharedObject share) {
        this.share = share;
    }

    public void run() {
        System.out.println("[ WriteThread#run ] Start");
        share.writeProcess();
        System.out.println("[ WriteThread#run ] Finish");
    }
}

/* ======================================== */
class SharedObject {

    private int data;

    public SharedObject(int data) {
        this.data = data;
    }

    synchronized public int readProcess() {
        System.out.println("[ SharedObject#readProcess ] Start, data => " + data);

        try {
            // ロックを解放し、ウェイトセットに入る
            System.out.println("[ SharedObject#readProcess ] Waiting for WriteProcess...");
            wait();
            System.out.println("[ SharedObject#readProcess ] Restart");
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        System.out.println("[ SharedObject#readProcess ] Finish, data => " + data);
        return data;
    }

    synchronized public void writeProcess() {
        System.out.println("[ SharedObject#writeProcess ] Start");

        // 意図的に5000ミリ秒スリープする
        sleepAWhile(5000);

        // dataフィールドに値を書き込む
        data = 10;

        // ReadThreadに通知を送る
        System.out.println("[ SharedObject#writeProcess ] Notify to ReadProcess");
        notifyAll();

        System.out.println("[ SharedObject#writeProcess ] Finish, data => " + data);
    }
}