package pro.kensait.java.thread.safe;

public class SingleThreadExecutionMain {

    public static void main(String[] args) throws Exception {
        // 共有オブジェクトを生成する。
        SharedObject share = new SharedObject();

        // 1つ目のスレッドを生成し、開始する。
        Task t1 = new Task(share, 1);
        t1.start();

        // 1つ目のスレッドを生成し、開始する。
        Task t2 = new Task(share, 2);
        t2.start();

        t1.join();
        t2.join();

        System.out.println(share.getData());
    }
}

