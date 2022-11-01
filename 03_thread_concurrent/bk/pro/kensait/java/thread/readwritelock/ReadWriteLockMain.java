package pro.kensait.java.thread.readwritelock;

import static pro.kensait.java.thread.util.ThreadUtil.*;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMain {

    public static void main(String[] args) throws Exception {
        // 共有オブジェクトを生成する
        SharedObject share = new SharedObject(10);

        // 1つ目のスレッド（ReadTask）を生成し、起動する
        ReadThread t1 = new ReadThread(share);
        t1.start();

        // 2つ目のスレッド（WriteTask）を生成し、起動する
        WriteThread t2 = new WriteThread(share);
        t2.start();
        sleepAWhile(2000);

        // 3つ目のスレッド（ReadTask）を生成し、起動する
        ReadThread t3 = new ReadThread(share);
        t3.start();
    }
}

/* ======================================== */
class ReadThread extends Thread {

    private SharedObject share;

    public ReadThread(SharedObject share) {
        this.share = share;
    }

    public void run() {
        System.out.println("[ ReadThread ] start");
        int result = share.readProcess();
        System.out.println("[ ReadThread ] finish, result => " + result);
    }
}

/* ======================================== */
class WriteThread extends Thread {

    private SharedObject share;

    public WriteThread(SharedObject share) {
        this.share = share;
    }

    public void run() {
        System.out.println("[ WriteThread ] start");
        share.writeProcess();
        System.out.println("[ WriteThread ] finish");
    }
}

/* ======================================== */
class SharedObject {

    private int data;

    public SharedObject(int data) {
        this.data = data;
    }

    private ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    public int readProcess() {
        readLock.lock();
        System.out.println("[ SharedObject#readProcess ] After lock");

        // 意図的に5000ミリ秒スリープする
        sleepAWhile(5000);

        try {
            System.out.println("[ SharedObject#readProcess ] data => " + data);
            return data;
        } finally {
            readLock.unlock();
        }
    }

    public void writeProcess() {
        writeLock.lock();
        System.out.println("[ SharedObject#writeProcess ] After lock");

        // 意図的に5000ミリ秒スリープする
        sleepAWhile(5000);

        try {
            // dataフィールドに値を書き込む。
            data = data + 10;
            System.out.println("[ SharedObject#writeProcess ] data => " + data);
        } finally {
            writeLock.unlock();
        }
    }
}