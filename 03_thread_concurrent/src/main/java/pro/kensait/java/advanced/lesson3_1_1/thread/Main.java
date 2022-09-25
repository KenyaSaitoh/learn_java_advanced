package pro.kensait.java.advanced.lesson3_1_1.thread;

public class Main {

    public static void main(String[] args) {
        // スレッドを生成する［①］
        MyThread t = new MyThread(3);

        System.out.println("[ ThreadMain ] start");
        // スレッドを起動する［②］
        t.start();
        System.out.println("[ ThreadMain ] Finish");
    }
}