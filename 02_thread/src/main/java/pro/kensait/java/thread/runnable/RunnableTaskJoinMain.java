package pro.kensait.java.thread.runnable;

public class RunnableTaskJoinMain {

    public static void main(String[] args) throws Exception {

        Thread thread1 = new Thread(new RunnableTask("Foo"));
        Thread thread2 = new Thread(new RunnableTask("FooFoo"));
        Thread thread3 = new Thread(new RunnableTask("FooFooFoo"));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        thread3.start();
    }
}