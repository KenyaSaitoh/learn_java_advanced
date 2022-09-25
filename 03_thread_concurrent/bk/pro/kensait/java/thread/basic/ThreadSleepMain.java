package pro.kensait.java.thread.basic;

public class ThreadSleepMain {

    public static void main(String[] args) {
        System.out.println("[ ThreadSleepMain ] start");
        try {
            Thread.sleep(5000); // 5000ミリ秒停止
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        System.out.println("[ ThreadSleepMain ] Finish");
    }
}