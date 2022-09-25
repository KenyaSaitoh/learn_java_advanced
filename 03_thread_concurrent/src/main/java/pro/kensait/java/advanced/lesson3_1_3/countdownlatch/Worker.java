package pro.kensait.java.advanced.lesson3_1_3.countdownlatch;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {
    private String name;
    private CountDownLatch startSignal;
    private CountDownLatch doneSignal;

    public Worker(String name, CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.name = name;
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            // 処理を待機する
            System.out.println("[ " + name + " ] awaiting...");
            startSignal.await();

            // 処理を進める
            System.out.println("[ " + name + " ] do something...");
            doSomething(2, 7);

            // 処理終了を通知する
            System.out.println("[ " + name + " ] finish");
            doneSignal.countDown();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }
}