package pro.kensait.java.thread.runnable;

import static pro.kensait.java.thread.util.ThreadUtil.*;

public class RunnableTask implements Runnable {

    private String param;

    public RunnableTask(String param) {
        this.param = param;
    }

    public void run() {
        System.out.println("[ RunnableCommand#run ] param ---> " + param);

        // 意図的に3000ミリ秒～15000秒（ランダムに決定）スリープする。
        try {
            sleepRandomTime(3000, 15000);
        } catch(RuntimeException re) {
        }

        int length = param.length();
        System.out.println("param: " + param + ", length: " + length);
    }
}