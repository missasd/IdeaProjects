package DesignPattern.Behavior.MediatorPattern;

import java.util.Date;

public class Blackboard {

    public static void showMessage(Student student, String message){
        System.out.println(new Date().toString() + student.getName() + " say: " + message);
    }
}
