package pro.kensait.java.thread.runnable;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RunnableTaskSingleMain {

    public static void main(String[] args) throws Exception {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new RunnableTask("Foo"));
    }
}