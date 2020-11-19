package java7ConcurrentProgram.chp6.p2ConcurrentLinkedDeque;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements Runnable{

    private ConcurrentLinkedDeque<String> list;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + " : Element " + i);
        }
    }

    public AddTask(ConcurrentLinkedDeque<String> list){
        this.list = list;
    }
}
