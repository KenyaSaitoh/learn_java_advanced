package pro.kensait.java.thread.immutable;

public class ThreadSafeMain {

    public static void main(String[] args) throws Exception {

        String property = "foo";
        
        // 1つ目のスレッドを生成し、開始する
        Task t1 = new Task(property);
        t1.start();

        // 2つ目のスレッドを生成し、開始する
        Task t2 = new Task(property);
        t2.start();

        // t1、t2の処理終了を待機する
        t1.join();
        t2.join();

        // 当初は同じプロパティを共有していたが、Stringクラスはイミュータブルなため、
        // t1、t2、双方でプロパティを同時に更新しても影響はない
        System.out.println("t1 => " + t1.getProperty());
        System.out.println("t2 => " + t2.getProperty());
    }
}