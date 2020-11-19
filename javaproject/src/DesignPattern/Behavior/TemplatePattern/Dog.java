package DesignPattern.Behavior.TemplatePattern;

public class Dog extends Animal {

    @Override
    void Birth() {
        System.out.println("The dog birth");
    }

    @Override
    void Growup() {
        System.out.println("The dog grow up");
    }

    @Override
    void Dead() {
        System.out.println("The dog dead");
    }
}
