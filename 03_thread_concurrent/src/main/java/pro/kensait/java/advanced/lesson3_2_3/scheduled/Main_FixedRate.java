package pro.kensait.java.advanced.lesson3_2_3.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main_FixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        RunnableTask task = new RunnableTask();
        System.out.println("[ Main ] starting task...");
        // 2秒遅れて開始し、7秒毎に繰り返しタスクを実行する
        // ここではタスクは約4～9秒で終わる
        // 仮に7秒未満で終わった場合は、差分の分だけ遅延させる
        // 仮に7秒以上かかった場合は、遅れを取り戻すために、即時実行される
        // 固定的に7秒というフレームに極力合わせるようにタスクをスケジューリングする
        executor.scheduleAtFixedRate(task, 2L, 7L, TimeUnit.SECONDS);
        System.out.println("[ Main ] finish");
    }
}