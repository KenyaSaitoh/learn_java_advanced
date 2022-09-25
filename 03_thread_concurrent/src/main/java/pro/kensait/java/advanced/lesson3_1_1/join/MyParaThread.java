package pro.kensait.java.advanced.lesson3_1_1.join;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

public class MyParaThread extends Thread {
    private long timer;
    
    public MyParaThread(String name, long timer) {
        super(name);
        this.timer = timer;
    }

    @Override
    public void run() {
        System.out.println("[ MyParaThread ] start, name => " + getName());
        sleepAWhile(timer); // 指定されたミリ秒間、一時停止するユーティリティ
        System.out.println("[ MyParaThread ] Finish, name => " + getName());
    }
}