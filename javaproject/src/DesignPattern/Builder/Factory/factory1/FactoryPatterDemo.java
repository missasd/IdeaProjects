package DesignPattern.Builder.Factory.factory1;

/**
 *  工厂模式
 *  意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类
 *  工厂模式使其创建工厂延迟到子类进行；
 */
public class FactoryPatterDemo {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        // 获取Circle对象，并调用它的draw方法
        Shape circle = factory.getShape("CIRCLE");
        circle.draw();
    }
}
