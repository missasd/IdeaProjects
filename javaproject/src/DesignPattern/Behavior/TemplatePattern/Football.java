package DesignPattern.Behavior.TemplatePattern;

public class Football extends Game {

    @Override
    void initialize() {
        System.out.println("Football Game Initialized");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game! Starting playing ");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished");
    }
}
