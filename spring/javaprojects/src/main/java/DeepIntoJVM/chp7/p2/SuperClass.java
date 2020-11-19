package DeepIntoJVM.chp7.p2;

public class SuperClass {
    static {
        System.out.println("SuperClass init");
    }
    // 父类中定义静态字段
    public static int value = 123;
}
