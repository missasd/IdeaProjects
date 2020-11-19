package SevenWeekSevenCon.chp1.p1;

public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from new Thread");
            }
        });
        // 1. 创建并启动一个Thread实例，从start()开始
        // myThread.run()函数与main()函数的余下部分一起并发执行
        // main线程调用join来等待myThread线程结束，即run()函数返回
        myThread.start();
        //Thread.yiele()作用，通知调度器，当前线程想要让出对处理器的占用
        Thread.yield();
        // Thread.sleep(1000);
        System.out.println("Hello from main Thread");
        myThread.join();
    }
}
