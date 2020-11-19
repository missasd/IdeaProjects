package HighlyConcurrent.chp6.p5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 6.5.4　CompletableFuture中的异常处理
 */
public class Except_Process {

    public static Integer calc(Integer para){
        return para / 0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

    }
}
