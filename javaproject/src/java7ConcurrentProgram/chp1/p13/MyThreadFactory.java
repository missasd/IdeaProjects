package java7ConcurrentProgram.chp1.p13;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name){
        counter = 0;
        this.name = name;
        stats = new ArrayList<String>();
    }

    @Override
    public Thread newThread(Runnable r){
        Thread t = new Thread(r, name+"-Thread_"+counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s ong %s\t", t.getId(), t.getName(), new Date()));
        return t;
    }

    public String getState(){
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = stats.iterator();
        while (it.hasNext()){
            buffer.append(it.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
