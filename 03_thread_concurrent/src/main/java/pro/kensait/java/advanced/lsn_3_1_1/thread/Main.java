package pro.kensait.java.advanced.lsn_3_1_1.thread;

public class Main {

    public static void main(String[] args) throws Exception {
        // スレッドを生成する
        MyThread t = new MyThread(3);

        System.out.println("[ Main ] start");
        // スレッドを起動する
        t.start();
        System.out.println("[ Main ] finish");
    }
}