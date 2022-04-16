package pro.kensait.java.thread.basic;

public class ThreadMain1 {

    public static void main(String[] args) {
        // 1つ目のスレッドを生成し、開始する。
        MyThread t1 = new MyThread("Foo");
        t1.start();

        // 2つ目のスレッドを生成し、開始する。
        MyThread t2 = new MyThread("Bar");
        t2.start();
    }
}

/* ======================================== */
class MyThread extends Thread {

    String param;

    public MyThread(String param) {
        this.param = param;
    }

    public void run() {
        System.out.println("[ MyThread#run ] Start");
        System.out.println("Parameter ---> " + param);
    }
}