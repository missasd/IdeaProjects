package java8inaction.chp1.p1.q1;

public class Singleton {
    // public static int STATUS = 1;
    // 若调用STATUS则会导致类初始化，并创建instance实例；
    private Singleton(){
        System.out.println("Singleton is create");
    }
    // 静态成员instance会在类第一次初始化的时候被创建；
    // 这个时刻并不一定是getInstace()第一次被调用
    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}
