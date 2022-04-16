package pro.kensait.java.pattern.thread.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import pro.kensait.java.thread.util.ThreadUtil;

public class SharedObject {

    private int data = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    public int readProcess() {
        readLock.lock();
        System.out.println("[ SharedObject#readProcess ] After lock");
        ThreadUtil.sleepAWhile(5000);
        try {
            System.out.println("[ SharedObject#readProcess ] data ---> " + data);
            return data;
        } finally {
            readLock.unlock();
        }
    }

    public void writeProcess(int param) {
        writeLock.lock();
        System.out.println("[ SharedObject#writeProcess ] After lock");
        ThreadUtil.sleepAWhile(5000);
        try {
            // dataフィールドに値を書き込む。
            data = data + param;
            System.out.println("[ SharedObject#writeProcess ] data ---> " + data);
        } finally {
            writeLock.unlock();
        }
    }
}
