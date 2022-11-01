package pro.kensait.java.advanced.lesson3_1_1.thread;

public class MyThread extends Thread {
    private int data;

    public MyThread(int data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[ MyThread ] start");
        long total = 0;
        for (long i = 0; i < 100_000_000_000L; i++) { // 1000億回
            total += data;
        }
        System.out.println("[ MyThread ] finish, total => " + total);
    }
}