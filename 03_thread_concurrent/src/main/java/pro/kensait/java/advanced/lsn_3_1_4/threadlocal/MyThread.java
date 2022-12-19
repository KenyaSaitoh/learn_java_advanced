package pro.kensait.java.advanced.lsn_3_1_4.threadlocal;

public class MyThread extends Thread {
    @Override
    public void run() {
        ThreadLocalHolder.get().put("name", "Alice");
        Foo foo = new Foo();
        foo.process();
    }
}