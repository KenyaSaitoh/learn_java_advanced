package pro.kensait.java.thread.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalMain {

    public static void main(String[] args) {
        // スレッドt1を生成し、起動する
        MyThread t1 = new MyThread("Foo");
        t1.start();

        // スレッドt2を生成し、起動する
        MyThread t2 = new MyThread("Bar");
        t2.start();
    }
}

/* ======================================== */
class MyThread extends Thread {

    private String property;

    public MyThread(String property) {
        this.property = property;
    }

    public void run() {
        ThreadLocalHolder.get().put("key", property + property);
        process();
    }

    public void process() {
        String value = ThreadLocalHolder.get().get("key");
        System.out.println("[ MyThread#process ] " + property + " => " + value);
    }
}

/* ======================================== */
class ThreadLocalHolder {

    private static ThreadLocal<Map<String, String>> context =
            new ThreadLocal<>() {
        @Override
        public Map<String, String> initialValue() {
            return new HashMap<String, String>();
        }
    };

    public static Map<String, String> get() {
        return context.get();
    }
}