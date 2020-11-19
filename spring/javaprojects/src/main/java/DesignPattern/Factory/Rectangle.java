package DesignPattern.Factory;

/**
 * 步骤2、创建接口的实现类
 */
public class Rectangle implements Shape {
    @Override
    public void draw(){
        System.out.println("Inside Rectangle");
    }
}
