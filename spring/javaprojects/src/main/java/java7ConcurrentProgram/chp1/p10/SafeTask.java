package java7ConcurrentProgram.chp1.p10;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable{
    private static ThreadLocal<String> startDate = new ThreadLocal<String>(){
        protected String initialValue(){
            return new Date()+"";
        }
    };
    @Override
    public void run() {

        System.out.printf("Starting thread : %s %s \n", Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread : %s finished %s", Thread.currentThread().getId(), startDate.get());

    }

}
