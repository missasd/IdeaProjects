package algs4.chp1.p2.q1;

/**
 * 插入排序 很像冒泡排序
 */
public class InsertSort1 {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (arr[j] < arr[j-1]){
                    // 将其值进行交换
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {29,10,14,37,14};
        InsertSort1.sort(arr);
        for (int a: arr) {
            System.out.print(a+ " ");
        }
    }
}
