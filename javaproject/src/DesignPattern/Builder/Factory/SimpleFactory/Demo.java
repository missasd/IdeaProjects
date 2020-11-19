package DesignPattern.Builder.Factory.SimpleFactory;

public class Demo {
    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        Phone miPhone = factory.makePhone("MiPhone");
        Phone iPhone = factory.makePhone("IPhone");

    }
}
