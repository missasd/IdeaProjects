package DesignPattern.Builder.Factory.FactoryMethod;

import DesignPattern.Builder.Factory.SimpleFactory.IPhone;
import DesignPattern.Builder.Factory.SimpleFactory.Phone;

/**
 * ConcreteFactory2
 */
public class AppleFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new IPhone();
    }
}
