package DesignPattern.Behavior.NullObjectPattern;

/**
 * 创建了一个 未对抽象类做任何实现的空对象类；
 * 空对象类将用于在需要检查空值的地方；
 */
public class NullCustomer extends AbstractCustomer {

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }

    @Override
    public boolean isNil() {
        return true;
    }
}
