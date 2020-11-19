package HighlyConcurrent.chp3.p3.q9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 计算数列求和
 * ForJoinTask类支持fork（）方法分解，join（）方法等待
 * ForkJoinTask()类有两个子类：
 *  RecursiveAction（）类：没有返回值的任务
 *  RecursiveTask（）类：可携带返回值的任务
 */
public class CountTask extends RecursiveTask<Long> {
    // 任务分解的规模
    private static final int THRESHOLD = 10000;
    private long start; // 求和数列的起始数字
    private long end; // 求和数列的终止数字

    public CountTask(long start, long end){
        this.start = start;
        this.end = end;
    }

    public Long compute(){
        long sum = 0;
        boolean canCompute = (end - start)<THRESHOLD;
        if (canCompute){
            for (long i=start; i<=end; i++){
                sum +=i;
            }
        }else {
            //分成100个小任务
            long step = (start + end)/100;
            ArrayList<CountTask> subTasks = new ArrayList<>();
            long pos=start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos+step;
                if (lastOne>end)lastOne=end;
                CountTask subTask = new CountTask(pos, lastOne);
                pos+=step+1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for (CountTask t:subTasks){
                sum+=t.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0, 200000L);
        // 向ForkJoinPool线程池提交一个ForkJoinTask任务

        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try{
            long res = result.get();
            System.out.println("sum="+res);

        }catch (Exception e){
            e.printStackTrace();
        }

//        Collections.synchronizedMap()

    }
}
