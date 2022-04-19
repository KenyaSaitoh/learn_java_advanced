package pro.kensait.java.thread.deadlock;

import static pro.kensait.java.thread.util.ThreadUtil.*;

public class DeadlockMain {

    public static void main(String[] args) {
        (new DeadlockMain()).executeTask();
    }

    private void executeTask() {
        SharedObject objectX = new SharedObject(0); // 初期値が0の共有オブジェクトを生成する
        SharedObject objectY = new SharedObject(10000); // 初期値が10000の共有オブジェクトを生成する

        // カウンタが5のスレッドt5を生成し、起動する
        DeadlockThread t5 = new DeadlockThread("t5", objectX, objectY, 5);
        t5.start();

        sleepAWhile(1000);

        // カウンタが7のスレッドt7を生成し、t5から1秒遅れて起動する
        DeadlockThread t7 = new DeadlockThread("t7", objectY, objectX, 7);
        t7.start();
    }
}

/* ======================================== */
class DeadlockThread extends Thread {

    private String name;
    private SharedObject share1; // 共有オブジェクト1
    private SharedObject share2; // 共有オブジェクト2
    private int count; // カウンタ

    public DeadlockThread(String name, SharedObject share1, SharedObject share2,
            int count) {
        this.name = name;
        this.share1 = share1;
        this.share2 = share2;
        this.count = count;
    }

    public void run() {
        while (true) {
            synchronized (share1) { // まず共有オブジェクト1をロック
                System.out.println("[ " + name + ", 1 ] " + share1.getData());
                share1.addData(count); // スレッドが保持しているカウンタで共有オブジェクト1の値を更新
                System.out.println("[ " + name + ", 1 ] " + share1.getData());
                synchronized (share2) { // 共通オブジェクト1にロックをかけたまま、共有オブジェクト2をロック
                    System.out.println("[ " + name + ", 2 ] " + share2.getData());
                    share2.addData(count); // スレッドが保持しているカウンタで共有オブジェクト2の値を更新
                    System.out.println("[ " + name + ", 2 ] " + share2.getData());
                }
            }
        }
    }
}

/* ======================================== */
class SharedObject {

    private int data;

    public SharedObject(int data) {
        this.data = data;
    }

    // dataフィールドへの更新処理
    public void addData(int num) {
        int tmp = this.data + num;
        sleepAWhile(100);
        this.data = tmp;
    }

    public int getData() {
        return data;
    }
}