package pro.kensait.java.thread.readwritelock;

public class ReadWriteLockMain {

    public static void main(String[] args) throws Exception {
        // 共有オブジェクトを生成する。
        SharedObject share = new SharedObject();

        // 1つ目のスレッド（ReadTask）を生成し、開始する。
        ReadTask t1 = new ReadTask(share);
        t1.start();

        // 2つ目のスレッド（ReadTask）を生成し、開始する。
        ReadTask t2 = new ReadTask(share);
        t2.start();

        // 3つ目のスレッド（WriteTask）を生成し、開始する。
        WriteTask t3 = new WriteTask(share, 10);
        t3.start();
        t1.join();
        t2.join();

        // 4つ目のスレッド（ReadTask）を生成し、開始する。
        ReadTask t4 = new ReadTask(share);
        t4.start();
    }
}
