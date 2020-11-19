package HighlyConcurrent.chp6.p5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 一个CompletableFuture可以在执行完成后，
 * 将执行结果通过Function接口传递给下一个CompletionStage实例
 * 进行处理
 */
public class Combine_Future {

    public static Integer calc(Integer para){
        return para / 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> fu =
                CompletableFuture.supplyAsync(() -> calc(50))
                        // 下面将处理后的结果传递给thenCompose()方法
                        // 并进一步传递给后续新生成的CompletableFuture实例
                .thenCompose((i) -> CompletableFuture.supplyAsync(() -> calc(i)))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::print);
        fu.get();
    }
}
