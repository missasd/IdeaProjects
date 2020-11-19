package algs4.chp2.p4;

import java.security.Key;

/**
 * 堆-Java实现，版本一
 */
public class Heap_1 <Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0; // pq[]数组中，pq[0]没有用

    // 上浮操作，若节点的值大于父节点的值。 （大根堆）
    private void swim(int k){
        while ( k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }
    // 下沉操作
    public void sink(int k){
        while ( 2 * k <= N){
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    // 比较操作
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    // 交换操作
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
