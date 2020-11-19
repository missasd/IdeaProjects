package algs4.chp2.p4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 大根堆
 * https://www.cnblogs.com/coprince/p/8603492.html
 */
public class MaxHeap <E extends Comparable<E>>{

    private ArrayList<E> list;

    public MaxHeap(){
        list = new ArrayList<E>();
    }

    // 返回父节点的索引
    private int parent(int i){
        return (i - 1)/2;
    }
    // 左子节点的索引
    private int leftChild(int i){
        return i * 2 + 1;
    }
    // 右子节点的索引
    private int rightChild(int i){
        return i * 2 + 2;
    }

    private void shiftUp(int k){
        while (k > 0 && list.get(k).compareTo(list.get(parent(k))) > 0){
            Collections.swap(list, k, parent(k));
            k = parent(k);
        }
    }

    public void add(E e){
        list.add(list.size(), e);
        shiftUp(list.size() - 1);
    }

    public E getFront(){
        return list.get(0);
    }

    private void shiftDown(int k){
        while (leftChild(k) < list.size()){
            int j = leftChild(k);
            if (j + 1 < list.size() && list.get(j).compareTo(list.get(j + 1)) < 0){
                j = rightChild(k);
            }
            if (list.get(k).compareTo(list.get(j)) < 0){
                Collections.swap(list, k, j);
            }else {
                break;
            }
            k = j;
        }
    }

    public E extractMax(){
        if (list.size() == 0){
            throw new IllegalArgumentException("Exception");
        }
        E retMax = list.get(0);
        Collections.swap(list, 0, list.size() - 1);
        list.remove(list.size() - 1);
        shiftDown(0);
        return retMax;
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public int getSize(){
        return list.size();
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.add(123);
        maxHeap.add(99);
        maxHeap.add(666);
        maxHeap.add(78);
        maxHeap.add(999);
        System.out.println("获取最大元素 " + maxHeap.getFront());
        int n = maxHeap.getSize();
        for (int i = 0; i < n-1; i++) {
            System.out.println("删除第" + i + "个元素: " + maxHeap.extractMax());

        }
        System.out.println("获取最大元素" + maxHeap.getFront());
    }

}
