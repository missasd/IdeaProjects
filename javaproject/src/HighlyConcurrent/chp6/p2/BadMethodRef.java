package HighlyConcurrent.chp6.p2;

import java.util.ArrayList;
import java.util.List;

public class BadMethodRef {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<Double>();
        for (int i = 1; i < 10 ; i++) {
            numbers.add(Double.valueOf(i));
        }
        /**
         * 代码试图将所有的Double元素转为String并将其输出，：
         * 但是在Double中同时存在两个toString()函数
         */
        //numbers.stream().map(Double::toString).forEach(System.out::println);
    }
}
