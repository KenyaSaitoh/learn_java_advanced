package pro.kensait.java.advanced.lesson3_3_1.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(3, new MyBarrierAction());
        System.out.println("[ Main ] starting all threads...");
        new Worker("t1", barrier).start();
        new Worker("t2", barrier).start();
        new Worker("t3", barrier).start();
        System.out.println("[ Main ] finish");
    }
}