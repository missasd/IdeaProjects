package HighlyConcurrent.chp6.p5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Combine_call2 {
    public static Integer calc(Integer para){
        return para / 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 首先，生成两个CompletableFuture实例，
        CompletableFuture<Integer> intFuture = CompletableFuture.supplyAsync(() -> calc(50));
        CompletableFuture<Integer> intFuture2 = CompletableFuture.supplyAsync(() -> calc(50));

        // 使用thenCombine()方法组合这两个实例，将两者的执行结果进行累加
        // 由 (i, j) -> (i + j)实现累加
        CompletableFuture<Void> fu = intFuture.thenCombine(intFuture2, (i, j) -> (i+j))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::print);
        fu.get();



    }
}
