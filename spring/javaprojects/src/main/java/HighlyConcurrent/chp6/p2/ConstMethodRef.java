package HighlyConcurrent.chp6.p2;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法引用也可以使用构造函数
 */
public class ConstMethodRef {
    @FunctionalInterface
    interface UserFactory<U extends User>{
        U create(int id, String name);
    }

    /**
     * UserFactory作为User的工厂类，是一个函数式接口
     * 当使用User::new创建接口实例时，
     * 系统会根据UserFactory.create()的函数签名来选择合适的User构造函数
     * 。在创建UserFactory实例后，对UserFactory.create()的调用，
     * 都会委托给User的实际构造函数进行，
     * 从而创建User对象实例。
     */
    static UserFactory<User> uf = User::new;

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        for (int i = 1; i < 10; i++) {
            users.add(uf.create(i, "billy"+Integer.toString(i)));
        }
        users.stream().map(User::getName).forEach(System.out::println);
    }
}
