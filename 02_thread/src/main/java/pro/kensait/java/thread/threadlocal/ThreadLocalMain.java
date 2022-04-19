package pro.kensait.java.thread.threadlocal;

import java.util.Map;
import java.util.HashMap;
import static pro.kensait.java.thread.util.ThreadUtil.sleepAWhile;

public class ThreadLocalMain {

    public static void main(String[] args) {
        FooThread foo = new FooThread();
        foo.start();
        BarThread bar = new BarThread();
        bar.start();
    }
}

/* ======================================== */
class FooThread extends Thread {

    public void run() {
        this.setDaemon(true);
        ThreadLocalHolder.get().put("key", "This is shared info");
    }
}

/* ======================================== */
class BarThread extends Thread {

    public void run() {
        this.setDaemon(true);
        String value = ThreadLocalHolder.get().get("key");
        System.out.println("[ BarThread ] value => " + value);
    }
}
/* ======================================== */
class ThreadLocalHolder {

    private static ThreadLocal<Map<String, String>> context =
            new ThreadLocal<>();

    public static Map<String, String> get() {
        if (context.get() == null) {
            context.set(new HashMap<String, String>());
        }
        return context.get();
    }
}