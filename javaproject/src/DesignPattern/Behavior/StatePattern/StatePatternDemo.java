package DesignPattern.Behavior.StatePattern;

public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        // startState.doAction(context) 将会调用context.setState(this)设置context对象的state属性；
        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
