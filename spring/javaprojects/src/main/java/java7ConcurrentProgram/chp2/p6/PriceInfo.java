package java7ConcurrentProgram.chp2.p6;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PriceInfo {
    private double price1;
    private double price2;

    // 声明读写锁
    private ReadWriteLock lock;

    public PriceInfo() {
        price1 = 1.0;
        price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }

    public double getPrice1(){
        // 先加上读锁
        lock.readLock().lock();
        // 然后获取属性，可防止脏读、不可重复读、幻读
        double value = price1;
        lock.readLock().unlock();
        return value;
    }

    public double getPrice2(){
        lock.readLock().lock();
        double value = price2;
        lock.readLock().unlock();
        return value;
    }

    public void setPrices(double price1, double price2){
        lock.writeLock().lock();
        this.price1 = price1;
        this.price2 = price2;
        lock.writeLock().unlock();
    }
}
