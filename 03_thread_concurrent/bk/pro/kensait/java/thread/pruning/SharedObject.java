package pro.kensait.java.thread.pruning;

import pro.kensait.java.thread.util.ThreadUtil;

public class SharedObject {

    private int data;

    public SharedObject(int data) {
        this.data = data;
    }

    public synchronized int readProcess() {
        System.out.println("[ SharedObject#readProcess ] start, data => " + data);

        try {
            // ロックを解放し、ウェイトセットに入る
            System.out.println("[ SharedObject#readProcess ] Waiting for WriteProcess...");
            wait();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        System.out.println("[ SharedObject#readProcess ] Finish, data => " + data);
        return data;
    }

    public synchronized void writeProcess() {
        System.out.println("[ SharedObject#writeProcess ] start");

        // 意図的に5000ミリ秒スリープする
        ThreadUtil.sleepAWhile(5000);

        // dataフィールドに値を書き込む
        data = 10;

        // ReadThreadに通知を送る
        System.out.println("[ SharedObject#writeProcess ] Notify to ReadProcess");
        notifyAll();

        System.out.println("[ SharedObject#writeProcess ] Finish, data => " + data);
    }
}
