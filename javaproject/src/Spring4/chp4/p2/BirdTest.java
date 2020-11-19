package Spring4.chp4.p2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 测试通过反射创建Bird实例，并调用相关方法
 */
public class BirdTest {

    public Bird introduce() throws Exception {
        // 1. 获取类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 2. 通过类加载器加载类得到Class实例
        Class clazz = classLoader.loadClass("Spring4.chp4.p2.Bird");
        // 通过Class实例，获取构造方法
        Constructor constructor = clazz.getDeclaredConstructor((Class[]) null);
        // 通过构造方法，创建一个对应类的实例
        Bird bird = (Bird) constructor.newInstance();
        // 通过Class实例，获取对应类的实例的某个方法
        Method setName = clazz.getMethod("setName", String.class);
        //  调用某个方法，完成属性的设置
        setName.invoke(bird, "twipsy");
        Method setAge = clazz.getMethod("setAge", Integer.class);
        setAge.invoke(bird, 12);
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(bird, "yellow");
        return bird;



    }

    public static void main(String[] args) throws Exception{
        System.out.println(new BirdTest().introduce());
    }
}
