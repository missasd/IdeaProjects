package algs4.chp1.p2.q1;

/**
 * 选择排序
 *  1， 从左往右遍历
 *      将遍历的起始位置设为当前最小值的索引
 *    2. 从其实位置遍历，比较并保存最小值的索引
 *  3. 将起始位置 与 最小值 进行比较，并交换。
 *
 *  达成的效果是，类似于冒泡排序，但是每次是将剩余未排序序列中的最小值交换位置到序列的首位。
 */
public class SelectSort {
    public int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {29,10,14,37,14};
        SelectSort selectSort = new SelectSort();
        int[] result = selectSort.sort(arr);
        for (int n: result) {
            System.out.print(n + " ");
        }

    }
}
