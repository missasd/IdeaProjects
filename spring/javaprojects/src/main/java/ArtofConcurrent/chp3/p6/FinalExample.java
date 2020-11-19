package ArtofConcurrent.chp3.p6;

public class FinalExample {
    int i;
    final int j; // final变量
    static FinalExample obj;
    public FinalExample(){
        i = 1;
        j = 2; // 在构造函数中对final修饰的实例变量完成初始化

    }

    public static void writer(){
        obj = new FinalExample();
    }

    public static void reader(){
        FinalExample obje = obj;
        int a = obje.i;
        int b = obje.j;
    }
}
