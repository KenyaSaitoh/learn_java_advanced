package pro.kensait.java.advanced.lesson3_1_4.threadlocal;

public class MyThread extends Thread {
    @Override
    public void run() {
        ThreadLocalHolder.get().put("name", "Alice");
        process();
    }

    public void process() {
        String value = ThreadLocalHolder.get().get("name");
        System.out.println("[ MyThread#process ] name => " + value);
    }
}