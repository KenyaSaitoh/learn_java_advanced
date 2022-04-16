package pro.kensait.java.thread.join;

public class ThreadJoinMain {

    public static void main(String[] args) {
        // 1つ目のスレッドを生成し、開始する。
        System.out.println("===== THREAD 1 START =====");
        JoinThread t1 = new JoinThread(3000);
        t1.start();

        // 2つ目のスレッドを生成し、開始する。
        System.out.println("===== THREAD 2 START =====");
        JoinThread t2 = new JoinThread(5000);
        t2.start();


        try {
            // t1とジョインする。
            t1.join();
            System.out.println("===== THREAD 1 END =====");
            // t2とジョインする。
            t2.join();
            System.out.println("===== THREAD 2 END =====");
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }
}

/* ======================================== */
class JoinThread extends Thread {

    int timer;

    public JoinThread(int timer) {
        this.timer = timer;
    }

    public void run() {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }
}