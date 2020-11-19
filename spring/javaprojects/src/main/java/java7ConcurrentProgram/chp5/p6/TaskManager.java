package java7ConcurrentProgram.chp5.p6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

public class TaskManager {

    private List<ForkJoinTask<Integer>> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }

    public void addTask(ForkJoinTask<Integer> task){
        tasks.add(task);
    }

    public void cancelTasks(ForkJoinTask<Integer> cancelTask){
        for (ForkJoinTask<Integer> task : tasks){
            task.cancel(true);
            //((SearchNumberTask)task).writeCancelMessage();
        }
    }

}
