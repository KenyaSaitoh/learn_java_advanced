package pro.kensait.java.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorMain {

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // コアプールサイズ
                4, // 最大プールサイズ
                10, // キープアライブタイム
                TimeUnit.SECONDS, // 時間単位
                queue); // コマンドを格納するキュー

        try {
            MyCommand command1 = new MyCommand("1");
            executor.execute(command1);

            MyCommand command2 = new MyCommand("2");
            executor.execute(command2);

            MyCommand command3 = new MyCommand("3");
            executor.execute(command3);

            MyCommand command4 = new MyCommand("4");
            executor.execute(command4);

            MyCommand command5 = new MyCommand("5");
            executor.execute(command5);

            MyCommand command6 = new MyCommand("6");
            executor.execute(command6);

        } finally {
            // ThreadPoolExecutorは、Runnableの投入を待ち続けるため、
            // shutdownを呼び出さないと、プログラムが終了しない
            executor.shutdown();
        }
    }
}