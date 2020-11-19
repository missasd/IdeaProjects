package ArtofConcurrent.chp4.p4_1;

public interface ThreadPool<Job extends Runnable> {
    // 执行一个Job，这个Job需要实现Runnable

    /**
     * 客户端可以通过execute(Job)方法将Job提交入线程池执行
     * 客户端本身不用等待Job的执行完成；
     * 每个客户端提交的Job都将进入到一个工作队列中等待工作者线程的处理
     * @param job
     */
    void execute(Job job);
    // 关闭线程池
    void shutdonw();
    // 增加工作者线程
    void addWorkers(int num);
    // 减少工作者线程
    void removeWorker(int num);
    // 得到正在等待执行的任务数
    int getJobSize();
}
