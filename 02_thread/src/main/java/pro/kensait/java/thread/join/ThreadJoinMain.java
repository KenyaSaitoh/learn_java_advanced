package pro.kensait.java.thread.join;

import static pro.kensait.java.thread.util.ThreadUtil.*;

public class ThreadJoinMain {

    public static void main(String[] args) throws Exception {
        // 3つのスレッドを生成する
        JoinThread t1 = new JoinThread("Foo");
        JoinThread t2 = new JoinThread("Bar");
        JoinThread t3 = new JoinThread("Baz");

        t1.start(); // t1を開始する
        t2.start(); // t2を開始する
        t1.join(); // t1の処理終了を待機する
        t2.join(); // t2の処理終了を待機する
        t3.start(); // t3を開始する
    }
}

/* ======================================== */
class JoinThread extends Thread {

    private String property;

    public JoinThread(String property) {
        this.property = property;
    }

    public void run() {
        System.out.println("[ JoinThread ] Start, property => " + property);

        // 意図的に3000ミリ秒～10000秒（ランダムに決定）スリープする
        sleepRandomTime(3000, 10000);

        System.out.println("[ JoinThread ] Finish, property => " + property);
    }
}