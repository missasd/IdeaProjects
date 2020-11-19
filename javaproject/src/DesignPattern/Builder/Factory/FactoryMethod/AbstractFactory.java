package DesignPattern.Builder.Factory.FactoryMethod;

import DesignPattern.Builder.Factory.SimpleFactory.Phone;

public interface AbstractFactory {
    Phone makePhone();
}
