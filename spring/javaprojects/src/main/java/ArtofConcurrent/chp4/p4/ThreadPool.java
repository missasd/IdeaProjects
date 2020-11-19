package ArtofConcurrent.chp4.p4;

public interface ThreadPool<Job extends Runnable> {
    // 执行一个Job，这个Job实现Runnable
    void execute(Job jod);
    // 关闭线程池
    void shutdown();
    // 增加工作者线程
    void addWorkers(int num);
    // 减少工作者线程
    void removeWorker(int num);
    // 得到正在等待执行的任务数量
    int getJobSize();
}