package DesignPattern.Behavior.StatePattern;

/**
 * Context对象的行为随着状态对象state的改变而改变
 */
public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }
}
