package java7ConcurrentProgram.chp2.p5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock接口及其实现类ReentrantLock类来创建一个临界区，模拟打印队列
 */
public class PrintQueue {
    // final修饰的对象可以在构造器中初始化
    //
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object object){
        // 调用lock方法获取对锁对象的控制
        queueLock.lock();
        try {
            Long duration = (long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+" :PrintQueue: Printing " + duration/1000 + "seconds");
            Thread.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            // 释放对锁对象的控制
            queueLock.unlock();
        }
    }


}
