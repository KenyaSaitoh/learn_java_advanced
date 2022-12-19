package pro.kensait.java.advanced.lsn_3_1_2.readwritelock;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class Shared {
    private int data;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    public Shared(int data) {
        this.data = data;
    }

    // dataフィールドの書き込み
    public void addData(int num) {
        WriteLock writelock = lock.writeLock();
        writelock.lock();
        try {
            int tmp = this.data + num;
            sleepAWhile(10); // 10ミリ秒間、一時停止（割り込みのチャンス）
            this.data = tmp;
        } finally {
            writelock.unlock();
        }
    }

    // dataフィールドの読み込み
    public int getData() {
        ReadLock readLock = lock.readLock();
        readLock.lock();
        try {
            return data;
        } finally {
            readLock.unlock();
        }
    }
}