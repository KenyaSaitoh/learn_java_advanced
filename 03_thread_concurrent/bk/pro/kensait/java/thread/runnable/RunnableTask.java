package pro.kensait.java.thread.runnable;

import static pro.kensait.java.thread.util.ThreadUtil.*;

public class RunnableTask implements Runnable {

    private String property;

    public RunnableTask(String property) {
        this.property = property;
    }

    public void run() {
        System.out.println("[ RunnableCommand ] property => " + property);

        // 意図的に3000ミリ秒～15000秒（ランダムに決定）スリープする
        sleepRandomTime(3000, 15000);

        int length = property.length();
        System.out.println("property => " + property + ", length => " + length);
    }
}