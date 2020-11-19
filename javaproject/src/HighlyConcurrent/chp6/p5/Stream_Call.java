package HighlyConcurrent.chp6.p5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Stream_Call {
    public static Integer calc(Integer para){
        try {
            // 模拟一个长时间的执行
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        return para*para;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * supplyAsync()函数执行一个异步任务。
         * 连续使用流式调用对任务的处理结果进行加工
         * 直到最后的结果输出
         */
        CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() -> calc(50))
                .thenApply((i) -> Integer.toString(i))
                .thenApply( (str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        /**
         * 执行CompletableFuture.get()方法，
         * 目的是等待calc()函数执行完成。
         * 由于CompletableFuture异步执行的缘故，
         * 如果不进行这个等待调用，那么主函数不等calc()方法执行完毕就会退出
         */
        fu.get();
    }
}
