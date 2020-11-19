package DeepIntoJVM.chp7.p3;

public class Sub extends Parent {
    public static int B = A;

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
