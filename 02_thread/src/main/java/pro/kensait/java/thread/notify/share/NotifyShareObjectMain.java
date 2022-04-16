package pro.kensait.java.thread.notify.share;

import pro.kensait.java.thread.util.ThreadUtil;

public class NotifyShareObjectMain {

    public static void main(String[] args) {
        // 共有オブジェクトを生成する。
        Share share = new Share();

        // 1つ目のスレッド（ReadThread）を生成し、開始する。
        ReadThread t1 = new ReadThread(share, "ReadThread");
        t1.start();

        // 2つ目のスレッド（WriteThread）を生成し、開始する。
        WriteThread t2 = new WriteThread(share, "WriteThread");
        t2.start();
    }
}

/* ======================================== */
class ReadThread extends Thread {

    Share share;

    public ReadThread(Share share, String str) {
        super(str);
        this.share = share;
    }

    public void run() {
        System.out.println("[ ReadThread#run ] Start");
        System.out.println("[ ReadThread#run ] Call ReadProcess");
        int result = share.readProcess();
        System.out.println("[ ReadThread#run ] End / result ---> " + result);
    }
}

/* ======================================== */
class WriteThread extends Thread {

    Share share;

    public WriteThread(Share share, String str) {
        super(str);
        this.share = share;
    }

    public void run() {
        System.out.println("[ WriteThread#run ] Start");
        System.out.println("[ WriteThread#run ] Call WriteProcess");
        share.writeProcess();
        System.out.println("[ WriteThread#run ] End");
    }
}

/* ======================================== */
class Share {

    int data = 0;

    public synchronized int readProcess() {
        System.out.println("[ Share#readProcess ] Start / data ---> " + data);

        try {
            // ロックを解放し、ウェイトセットに入る。
            System.out.println("[ Share#readProcess ] Waiting for WriteProcess...");
            wait();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        System.out.println("[ Share#readProcess ] End / data ---> " + data);
        return data;
    }

    public synchronized void writeProcess() {
        System.out.println("[ Share#writeProcess ] Start");

        // 意図的に5000ミリ秒スリープする。
        ThreadUtil.sleepAWhile(5000);

        // dataフィールドに値を書き込む。
        data = 10;

        // ReadThreadに通知を送る。
        System.out.println("[ Share#writeProcess ] Notify to ReadProcess");
        notifyAll();

        System.out.println("[ Share#writeProcess ] End / data ---> " + data);
    }
}