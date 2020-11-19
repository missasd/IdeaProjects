package HighlyConcurrent.chp6.p6;

import java.util.concurrent.locks.StampedLock;

public class Point {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    void move(double deltaX, double deltaY){
        // 这是一个排他锁（写锁）
        long stamp = sl.writeLock();
        try{
            x += deltaX;
            y += deltaY;
        }finally {
            // 释放锁
            sl.unlockWrite(stamp);
        }
    }

    // 只读方法
    double distanceFromOrigin(){
        // 试图尝试一次乐观读，它会返回一个类似于时间戳的邮戳整数stamp。
        // 这个stamp就可以作为这一次锁获取的凭证。
        long stamp = sl.tryOptimisticRead();
        // 读取x, y的值
        double currentX = x;
        double currentY = y;
        // 使用validate()方法，判断这个stamp在读过程发生期间被修改过
        if (!sl.validate(stamp)){
            /**
             * stamp是不可用的，则意味着在读取的过程中，
             * 可能被其他线程改写了数据，因此有可能出现了脏读。
             * 如果出现这种情况，我们可以像处理CAS操作那样
             * 在一个死循环中一直使用乐观读，直到成功为止。
             */
            // 也可以升级锁的级别；这里是将乐观锁升级为悲观锁
            // 使用readLock()方法，获得悲观的读锁，并进一步读取数据
            // 如果当前对象正在被修改，则读锁的申请可能导致线程挂起
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            }finally {
                // 释放读锁
                sl.unlockRead(stamp);
            }
        }
        // 如果validata()返回true，则认为读有效
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
