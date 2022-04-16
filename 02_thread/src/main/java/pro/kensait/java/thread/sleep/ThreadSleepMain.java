package pro.kensait.java.thread.sleep;

public class ThreadSleepMain {

    public static void main(String[] args) {
        SleepThread t = new SleepThread();
        t.start();
    }
}

/* ======================================== */
class SleepThread extends Thread {

    public void run() {
        System.out.println("[ SleepThread#run ] Start");
        try {
            Thread.sleep(5000); // 5000ミリ秒停止
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        System.out.println("[ SleepThread#run ] End");
    }
}