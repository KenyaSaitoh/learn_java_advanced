package pro.kensait.java.threadlocal;

public class ThreadLocalMain {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Foo");
        thread1.start();

        MyThread thread2 = new MyThread("Bar");
        thread2.start();
    }
}

/* ======================================== */
class MyThread extends Thread {

    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        ThreadLocal<String> context = ThreadLocalHolder.getContext();
        context.set(threadName);
        System.out.println("MyThread : Value ---> " + threadName);
        ThreadLocalTarget target = new ThreadLocalTarget(threadName);
        target.executeTask();
    }
}

/* ======================================== */
class ThreadLocalTarget {

    private String threadName;

    public ThreadLocalTarget(String threadName) {
        this.threadName = threadName;
    }

    public void executeTask() {
        ThreadLocal<String> context = ThreadLocalHolder.getContext();
        String value = context.get();
        System.out.println("ThreadLocalTarget : ThreadName ---> " + threadName + ", Value ---> " + value);
    }
}

/* ======================================== */
class ThreadLocalHolder {

    private static ThreadLocal<String> context = new ThreadLocal<String>();

    public static ThreadLocal<String> getContext() {
        return context;
    }
}