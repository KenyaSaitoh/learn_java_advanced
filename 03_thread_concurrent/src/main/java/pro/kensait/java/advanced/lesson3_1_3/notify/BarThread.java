package pro.kensait.java.advanced.lesson3_1_3.notify;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

public class BarThread extends Thread {
    private Shared shared; // 共有インスタンス

    public BarThread(Shared shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        System.out.println("[ BarThread ] start");
        // 5000ミリ秒かかる複雑な計算処理を行い、その結果が12345だったとする
        sleepAWhile(5000);
        int result = 12345;

        // 共有インスタンスに結果を設定する
        shared.setAndNotifyData(result);
        System.out.println("[ BarThread ] finish");
    }
}