package HighlyConcurrent.chp6.p2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *lambda表达式即匿名函数，它是一段没有函数名的函数体，
 * 可以作为参数直接传递给相关的调用者
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        final int num = 2;
        /**
         * 在forEach()函数中，传入的就是一个lambda表达式
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach((Integer value) -> System.out.println(value));
        System.out.println("==============");
        // lambda表达式可以访问外部变量，
        // 与匿名内部对象一样，在这种情况下，外部的num变量必须声明为final，
        // 这样才能保证在lambda表达式中合法地访问它。
        Function<Integer, Integer> stringConverter = (from) -> from * num;
        System.out.println(stringConverter.apply(3));
    }
}
