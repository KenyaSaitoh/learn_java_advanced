package pro.kensait.java.thread.util;

import java.util.Random;

public class ThreadUtil {

    // 一定期間スリープする
    public static void sleepAWhile(long time) {
        try {
            Thread.sleep(time);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }

    // 指定された範囲内で、ランダムな期間スリープする
    public static void sleepRandomTime(long from, long to) {
        Random random = new Random();
        long sleepTime = from + random.nextInt((int)to - (int)from);
        try {
            Thread.sleep(sleepTime);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }
}
