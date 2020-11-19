package HighlyConcurrent.chp6.p2;

import java.util.ArrayList;
import java.util.List;

/**
 * lambda的方法引用的基本使用
 */
public class InstanceMethodRef
{
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            users.add(new User(i, "billy"+Integer.toString(i)));

        }
        users.stream().map(User::getName).forEach(System.out::println);
    }
}
