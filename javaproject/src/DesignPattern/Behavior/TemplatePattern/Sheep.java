package DesignPattern.Behavior.TemplatePattern;

public class Sheep extends Animal {

    @Override
    void Birth() {
        System.out.println("The sheep birth");
    }

    @Override
    void Growup() {
        System.out.println("The sheep grow up");
    }

    @Override
    void Dead() {
        System.out.println("The sheep was dead");
    }
}
