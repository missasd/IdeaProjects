package HighlyConcurrent.chp6.p5;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;

public class AskThread implements Runnable {
    /**
     * 定义一个AskThread线程。
     * 接收一个 CompletableFuture作为其构造函数，任务是计算CompletableFuture参数的平方
     *
     *
     */
    CompletableFuture<Integer> re = null;

    public AskThread(CompletableFuture<Integer> re) {
        this.re = re;
    }

    @Override
    public void run() {
        int myRe = 0;
        try {
            myRe = re.get() * re.get();
        } catch (Exception e) {
        }
        System.out.println(myRe);
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建一个实例
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        // 将这个对象实例传递给AskThread线程，并启动这个线程
        // 这个线程在执行到myRe = re.get() * re.get()时会阻塞，因为CompletableFuture中根本就没有它所需要的数据
        new Thread(new AskThread(future)).start();
        // 模拟长时间的计算过程
        Thread.sleep(1000);
        // 告知完成结果
        // 计算完成后，可以将最终数据载入CompletableFuture，并标记为完成状态
        future.complete(60);
    }

}
