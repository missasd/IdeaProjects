package DesignPattern.Behavior.MediatorPattern;

public class MediatorPatternDemo {

    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John");
        john.sendMessage("Hello ! Robert!");
        // =======================
        Student tom = new Student("Tom");
        Student jerry = new Student("Jerry");
        tom.sendMessage("Hello Jerry");
        jerry.sendMessage("Hello Tom");
    }
}
