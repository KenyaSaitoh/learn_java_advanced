package pro.kensait.java.advanced.lsn_3_1_4;

public class MyThread extends Thread {
    @Override
    public void run() {
        ThreadLocalHolder.get().put("name", "Alice"); //【1】
        Foo foo = new Foo();
        foo.process(); //【2】
    }
}