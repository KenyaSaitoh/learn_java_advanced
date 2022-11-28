package pro.kensait.java.thread.executor;

import pro.kensait.java.thread.util.ThreadUtil;

public class MyCommand implements Runnable {

    private String property;

    public MyCommand(String property) {
        this.property = property;
    }

    public void run() {
        System.out.println("[ MyCommand#run ] start (" + property + ")");

        // 意図的に3000ミリ秒～20000秒（ランダムに決定）スリープする
        try {
            ThreadUtil.sleepRandomTime(3000, 20000);
        } catch(RuntimeException re) {
        }

        System.out.println("[ MyCommand#run ] End (" + property + ")");
    }

    public String getValue() {
        return property;
    }
}