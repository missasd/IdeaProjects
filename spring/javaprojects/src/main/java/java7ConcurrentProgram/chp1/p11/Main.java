package java7ConcurrentProgram.chp1.p11;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("SearcherTask");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
