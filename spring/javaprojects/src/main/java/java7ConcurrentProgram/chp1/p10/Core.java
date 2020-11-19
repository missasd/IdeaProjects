package java7ConcurrentProgram.chp1.p10;

import java.util.concurrent.TimeUnit;

public class Core {

    public static void main(String[] args) {
        // task对象实现了Runnable接口
        UnsafeTask task = new UnsafeTask();
        for (int i = 0; i < 10; i++) {
            // 将task对象作为参数传递，并创建多个线程对象并启动这些线程
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
