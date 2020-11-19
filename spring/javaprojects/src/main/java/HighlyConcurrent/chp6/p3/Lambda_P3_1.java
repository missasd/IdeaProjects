package HighlyConcurrent.chp6.p3;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class Lambda_P3_1 {
    static int[] arr = {1,3,4,5,6,7,8,9,10};
    public static void main(String[] args) {
        // 传统的遍历打印数组元素方法
        for (int i:arr) {
            System.out.println(i);
        }
        System.out.println("============");
        /**
         *
         */
        Arrays.stream(arr).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
    }
}
