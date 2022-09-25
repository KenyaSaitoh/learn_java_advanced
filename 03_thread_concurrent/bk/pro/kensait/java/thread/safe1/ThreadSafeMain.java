package pro.kensait.java.thread.safe1;

public class ThreadSafeMain {

    public static void main(String[] args) throws Exception {
        // 共有オブジェクトを生成する
        SharedObject share = new SharedObject(0);

        // 1つ目のスレッドを生成し、起動する
        Task t1 = new Task(share, 1);
        t1.start();

        // 1つ目のスレッドを生成し、起動する
        Task t2 = new Task(share, 2);
        t2.start();

        t1.join();
        t2.join();

        System.out.println("最終的な値 => " + share.getData()); // 本来30
    }
}