package DeepIntoJVM.chp7.p3;

public class Parent {
    public static int A = 1;
    static {
        A = 2;
        System.out.println("Parent A :" + A);
    }
}
