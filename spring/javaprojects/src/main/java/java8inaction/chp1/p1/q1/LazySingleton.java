package java8inaction.chp1.p1.q1;

public class LazySingleton {
    private LazySingleton(){
        System.out.println("LazySingleton is create");
    }
    // 最初并不需要实例化instance
    private static LazySingleton instance = null;
    public static synchronized LazySingleton getInstance(){
        if (instance == null)
            // 当getInstance()方法被第一次调用的时候，创建单例对象；
            // 为防止多次被创建，使用synchronized关键字进行方法同步
            instance = new LazySingleton();
        return instance;
    }
}
