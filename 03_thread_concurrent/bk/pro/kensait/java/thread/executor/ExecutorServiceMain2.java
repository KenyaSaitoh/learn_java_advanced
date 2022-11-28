package pro.kensait.java.thread.executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pro.kensait.java.thread.util.ThreadUtil;

public class ExecutorServiceMain2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        MyCommand command1 = new MyCommand("1");
        executor.execute(command1);

        MyCommand command2 = new MyCommand("2");
        executor.execute(command2);

        MyCommand command3 = new MyCommand("3");
        executor.execute(command3);

        // shutdownを呼び出した後、command4を追加しようとすると例外
        // （java.util.concurrent.RejectedExecutionException）が発生する
        // ただし、command1～3は実行される
        // executor.shutdown();

        MyCommand command4 = new MyCommand("4");
        executor.execute(command4);

        ThreadUtil.sleepAWhile(10000);

        System.out.println("===== shutdownNow ======");

        @SuppressWarnings("unused")
        List<Runnable> commandList = executor.shutdownNow();

        /* 以下のようにしても何も表示されないおかしいな
        for (Runnable r: commandList) {
            MyCommand command = (MyCommand)r;
            System.out.println(command.getValue());
        }
        */
    }
}