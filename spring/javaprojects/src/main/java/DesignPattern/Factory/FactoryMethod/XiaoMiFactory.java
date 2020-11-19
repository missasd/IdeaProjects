package DesignPattern.Factory.FactoryMethod;

import DesignPattern.Factory.SimpleFactory.MiPhone;
import DesignPattern.Factory.SimpleFactory.Phone;

/**
 *  ConcreteFactory1 生产小米手机的工厂
 */
public class XiaoMiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}
