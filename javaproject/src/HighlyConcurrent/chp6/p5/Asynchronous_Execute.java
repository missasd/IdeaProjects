package HighlyConcurrent.chp6.p5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 6.5.2　异步执行任务
 */
public class Asynchronous_Execute {

    public static Integer calc(Integer para){
        try {
            // 模拟一个长时间的执行
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        return para * para;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 下面两行使用CompletableFuture.supplyAsync()方法构造一个CompletableFuture实例
         * 在supplyAsync()函数中，它会在一个新的线程中，执行传入的参数。
         * 在这里它会执行calc()方法。
         */
        final CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> calc(50));
        System.out.println(future.get());
    }
}
