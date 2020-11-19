package DesignPattern.Behavior.TemplatePattern;

public class Demo1 {

    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.animal();
        System.out.println();
        animal = new Sheep();
        animal.animal();
    }
}
