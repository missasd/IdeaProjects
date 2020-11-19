package leetcode.tag.Recursive;

public class Demo {
    static Demo demo = new Demo();

    static int a;
    static int b = 1;

    Demo(){
        a++;
        b++;
    }
    static Demo getInstance(){
        return demo;
    }

    public static void main(String[] args) {
        Demo demo = Demo.getInstance();
        System.out.println(a + " " + b); // 1 1
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1 == s2); // false
        s2.intern();
        System.out.println(s1 == s2); // false
    }
}
