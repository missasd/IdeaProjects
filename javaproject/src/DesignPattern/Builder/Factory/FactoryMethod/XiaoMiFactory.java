package DesignPattern.Builder.Factory.FactoryMethod;

import DesignPattern.Builder.Factory.SimpleFactory.MiPhone;
import DesignPattern.Builder.Factory.SimpleFactory.Phone;

/**
 *  ConcreteFactory1 生产小米手机的工厂
 */
public class XiaoMiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}
