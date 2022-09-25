package pro.kensait.java.thread.pruning;

public class NotifyShareObjectMain {

    public static void main(String[] args) {
        // 共有オブジェクトを生成する
        SharedObject share = new SharedObject(0);

        // 1つ目のスレッド（ReadTask）を生成し、起動する
        ReadTask t1 = new ReadTask(share, "ReadTask");
        t1.start();

        // 2つ目のスレッド（WriteTask）を生成し、起動する
        WriteTask t2 = new WriteTask(share, "WriteTask");
        t2.start();
    }
}