package pro.kensait.java.thread.basic;

public class ThreadMain2 {

    public static void main(String[] args) {
        // 1つ目のスレッドを生成し、開始する
        MyRunnable r1 = new MyRunnable("Foo");
        Thread t1 = new Thread(r1);
        t1.start();

        // 2つ目のスレッドを生成し、開始する
        MyRunnable r2 = new MyRunnable("Bar");
        Thread t2 = new Thread(r2);
        t2.start();
    }
}

/* ======================================== */
class MyRunnable implements Runnable {

    String param;

    public MyRunnable(String param) {
        this.param = param;
    }

    public void run() {
        System.out.println("[ MyRunnable#run ] Start");
        System.out.println("Parameter => " + param);
    }
}