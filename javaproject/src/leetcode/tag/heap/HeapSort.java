package leetcode.tag.heap;

import java.lang.reflect.Array;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort {
    public static void heapSort(int arr[], int k){
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.add(0);
        }
        for (int a : arr){
            if (a > heap.peek()){
                heap.poll();
                heap.offer(a);
            }
        }
        for (int i : heap){
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 17, 20, 16};
        int k = 2;
        heapSort(arr, k);

    }
}
