package DesignPattern.Factory.AbstractFactory;

/**
 * 创建扩展了AbstractFactory的工厂类，基于给定的信息生成实体类的对象
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String color) {
        if (color == null) return null;
        if (color.equalsIgnoreCase("red")){
            return new Red();
        }else if (color.equalsIgnoreCase("green")){
            return new Green();
        }else if (color.equalsIgnoreCase("blue")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
