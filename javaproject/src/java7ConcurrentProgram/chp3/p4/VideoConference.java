package java7ConcurrentProgram.chp3.p4;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable{
    private CountDownLatch controller;

    public VideoConference(int number){
        // number为线程要等待完成的操作的数目
        controller = new CountDownLatch(number);
    }

    // 打印与会者信息
    public void arrive(String name){
        System.out.printf("%s has arrived. \n", name);
        // 操作完成后，countDown()方法将类的内部计数器减1，当计数器为0的时候，
        // 类将唤醒所有调用await()方法而进入休眠的线程；
        controller.countDown();
        // 打印出还没有到达的与会者数目
        System.out.printf("VideoConference waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference Initialization  %d pariticipants. \n ", controller.getCount());
        try {
            // 让这个线程进入休眠直到等待的所有操作都完成
            controller.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
