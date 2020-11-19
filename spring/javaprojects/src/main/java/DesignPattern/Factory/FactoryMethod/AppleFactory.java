package DesignPattern.Factory.FactoryMethod;

import DesignPattern.Factory.SimpleFactory.IPhone;
import DesignPattern.Factory.SimpleFactory.Phone;

/**
 * ConcreteFactory2
 */
public class AppleFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new IPhone();
    }
}
