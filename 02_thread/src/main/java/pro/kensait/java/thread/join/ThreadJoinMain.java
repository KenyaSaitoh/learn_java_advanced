package pro.kensait.java.thread.join;

import static pro.kensait.java.thread.util.ThreadUtil.sleepAWhile;

public class ThreadJoinMain {

    public static void main(String[] args) {
        // 1つ目のスレッドを生成し、開始する
        System.out.println("[ T-1 ] Start");
        JoinThread t1 = new JoinThread(3000);
        t1.start();

        // 2つ目のスレッドを生成し、開始する
        System.out.println("[ T-2 ] Start");
        JoinThread t2 = new JoinThread(5000);
        t2.start();

        try {
            // t1とジョインする
            t1.join();
            System.out.println("[ T-1 ] Finish");
            // t2とジョインする
            t2.join();
            System.out.println("[ T-2 ] Finish");
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }
}

/* ======================================== */
class JoinThread extends Thread {

    private long timer;

    public JoinThread(long timer) {
        this.timer = timer;
    }

    public void run() {
        sleepAWhile(timer);
    }
}