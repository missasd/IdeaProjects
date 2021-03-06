package HighlyConcurrent.chp6.p6;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * 6.6.2
 */
public class StampedLockCPUDemo {
    static Thread[] holdCpuThreads = new Thread[3];

    static final StampedLock lock = new StampedLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run(){
                // 获得写锁（悲观锁）
                long readLong = lock.writeLock();
                LockSupport.parkNanos(600000000000L);
                // 释放锁
                lock.unlockWrite(readLong);
            }
        }.start();
        // 10秒
        Thread.sleep(100);
        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i] = new Thread(new HoldCPUReadThread());
            holdCpuThreads[i].start();
        }
        // 线程中断后，会占用CPU
        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i].interrupt();
        }
    }

    private static class HoldCPUReadThread implements Runnable{

        @Override
        public void run(){
            long lockr = lock.readLock();
            System.out.println(Thread.currentThread().getName() + " 获得读锁");
            lock.unlockRead(lockr);
        }
    }
}
