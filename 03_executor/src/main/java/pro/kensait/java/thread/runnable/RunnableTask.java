package pro.kensait.java.thread.runnable;

import static pro.kensait.java.thread.util.ThreadUtil.*;

public class RunnableTask implements Runnable {

    private String name;

    public RunnableTask(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("[ RunnableCommand#run ] name => " + name);

        // 意図的に3000ミリ秒～15000秒（ランダムに決定）スリープする。
        sleepRandomTime(3000, 15000);

        int length = name.length();
        System.out.println("name => " + name + ", length => " + length);
    }
}