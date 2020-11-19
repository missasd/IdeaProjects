package DesignPattern.Builder.Factory;

public class TestFactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.getShape("CIRCLE");
        circle.draw();
    }
}
