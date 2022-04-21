package pro.kensait.java.thread.runnable;

public class RunnableTaskSingleMain1 {

    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(new RunnableTask("Foo"));
        thread.start();
    }
}