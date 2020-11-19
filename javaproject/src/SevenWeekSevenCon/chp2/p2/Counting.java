package SevenWeekSevenCon.chp2.p2;

/**
 * 两个线程使用counter.count 对象发生了竞态条件
 * 竞态条件：代码行为取决于执行的时序
 */
public class Counting {
    public static void main(String[] args) throws InterruptedException {
        class Counter{
            private int count = 0;
            // 线程进入increment()函数时，将获取Counter对象级别的锁
            // 函数返回时将释放锁；某一时间至多只能由一个线程可以执行函数体，
            // 其它线程调用函数时将会被被阻塞直到锁被释放；
            public synchronized void increment(){++count;}
            public int getCount(){return count;}
        }

        final Counter counter = new Counter();
        class CountingThread extends Thread{
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        }
        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Thread.currentThread().getName()+ " "+counter.getCount());

    }
}
