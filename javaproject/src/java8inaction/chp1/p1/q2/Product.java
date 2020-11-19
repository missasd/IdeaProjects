package java8inaction.chp1.p1.q2;

public final class Product { // 确保无子类
    private final String no; // 私有属性，不会被其它对象获取
    private final String name; // final保证属性不会被两次赋值
    private final double price;

    // 创建对象时必须指定数据，创建之后无法修改
    public Product(String no, String name, double price){
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
