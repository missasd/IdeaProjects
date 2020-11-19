package algs4.chp1.p2.q2;

public class SelectSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min_index = i;
            for (int j = i; j < arr.length ; j++) {
                if (arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            swap(arr, i, min_index);
        }
    }

    private static void swap(int[] arr, int v, int w){
        int temp = arr[v];
        arr[v] = arr[w];
        arr[w] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {29,10,14,37,14};
        SelectSort.sort(arr);
        for (int a: arr) {
            System.out.print(a + " ");
        }
    }
}
