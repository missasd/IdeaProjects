package DesignPattern.Behavior.MementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责从Memento中恢复对象的状态
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
