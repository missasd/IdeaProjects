package DeepIntoJVM.chp7.p2;

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
        int a = SubClass.value;

    }

}
