package DesignPattern.Behavior.TemplatePattern;

/**
 * 重写父类中的某些方法，但是调用这些方法的逻辑是在父类中被写死的
 */
public class Cricket extends Game {

    @Override
    public void endPlay(){
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started");
    }
}
