package java7ConcurrentProgram.chp5.p6;

import java.util.Random;

/**
 * 生成一个指定大小的随机整数数组
 */
public class ArrayGenerator {

    public int[] generateArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }
}
