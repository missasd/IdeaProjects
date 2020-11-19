package DesignPattern.Builder.Factory;

/**
 *  步骤四、使用该工厂，通过传递类型信息来获取实体类的对象
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // 获取Circle对象,并调用它的draw方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        // 调用Circle对象的draw方法
        shape1.draw();
    }
}
