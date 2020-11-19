package Spring4.chp4.p2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 代码清单4-13 PirvateCarReflect
 */
public class PriveteCarReflect {

    public static void main(String[] args) throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("Spring4.chp4.p2.PrivateCar");
        PrivateCar pcar = (PrivateCar)clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        // 取消Java语言访问检查以访问private变量
        colorFld.setAccessible(true);
        colorFld.set(pcar, "红色");

        Method driveMtd = clazz.getDeclaredMethod("drive", (Class[])null);

        driveMtd.invoke(pcar, (Object[])null);
    }
}
