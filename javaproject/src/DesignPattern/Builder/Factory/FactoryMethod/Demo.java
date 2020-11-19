package DesignPattern.Builder.Factory.FactoryMethod;

public class Demo {
    public static void main(String[] args) {
        AbstractFactory miFactory = new XiaoMiFactory(); // 多态
        AbstractFactory appleFactory = new AppleFactory();
        miFactory.makePhone();
        appleFactory.makePhone();
    }

}
