package pro.kensait.java.thread.safe1;

import pro.kensait.java.thread.util.ThreadUtil;

public class Task extends Thread {

    private SharedObject share;
    private int num;

    public Task(SharedObject share, int num) {
        this.share = share;
        this.num = num;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            ThreadUtil.sleepRandomTime(400, 500);
            share.addData(num);
            System.out.println(num + "加算する => " + share.getData());
        }
    }
}