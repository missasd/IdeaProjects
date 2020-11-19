package java8inaction.chp1.p1.q1;

public class StaticSingleton {
    private StaticSingleton(){
        System.out.println("StaticSingleton is create");
    }

    // 内部类被申明为private，使得不可能在外部访问并初始化它；
    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }
    // 只能在getInstance()方法内部对SingletonHolder类进行初始化；
    // 利用虚拟机的类初始化击值创建单例；
    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
