package pro.kensait.java.advanced.lesson3_1_1.runnable;

public class Main {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable(3);
        Thread t = new Thread(r); // スレッドを生成する
        System.out.println("[ RunnableMain ] start");
        t.start(); // スレッドを起動する
        System.out.println("[ RunnableMain ] Finish");
    }
}