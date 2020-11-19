package algs4.chp1.p2.q1;

/**
 * 插入排序
 */
public class InsertSort {
    public int[] sort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {29,10,14,37,14};
        InsertSort insertSort = new InsertSort();
        int [] result = insertSort.sort(arr);
        for (int n: result) {
            System.out.print(n + " ");

        }

    }
}
