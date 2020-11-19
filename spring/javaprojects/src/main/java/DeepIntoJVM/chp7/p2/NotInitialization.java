package DeepIntoJVM.chp7.p2;

/**
 * 被动引用情景之一：
 * 通过子类引用父类的静态字段，不会导致子类初始化；
 *
 * 对于静态字段，只有直接定义这个字段的类才会被初始化。
 * 通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化；
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);

        /**
         * 被动引用情景之二：
         * 通过数组定义来引用类，不会触发此类的初始化
         */
        SuperClass[] sca = new SuperClass[10];

    }
}
