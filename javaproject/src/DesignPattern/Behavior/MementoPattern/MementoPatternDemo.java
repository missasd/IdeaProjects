package DesignPattern.Behavior.MementoPattern;

public class MementoPatternDemo {
    public static void main(String[] args) {
        // 创建并在Memento对象中存储状态
        Originator originator = new Originator();
        // 负责从Memento中恢复对象的状态
        CareTaker careTaker = new CareTaker();

        originator.setState("State #1");
        // 设置状态
        originator.setState("State #2");
        // careTake将 originator.saveStateTomento()返回的Memento对象，保存到内部的队列中
        careTaker.add(originator.saveStateTomento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateTomento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());

        // careTaker.get(0)返回Memento对象，originator.getStateFromMemento(Memento memento)
        // 将memento的state属性写回到对象的state属性
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());

    }
}
