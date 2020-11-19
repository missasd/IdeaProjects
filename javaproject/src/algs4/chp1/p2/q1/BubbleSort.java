package algs4.chp1.p2.q1;

public class BubbleSort {
    public int[] sort(int[] array){
        if ( array==null || array.length <= 1){
            System.out.println("数组为空");
            return array;
        }

        for (int j=array.length-1; j>=0; j--){
            for (int i = 0; i < j ; i++) {
                if (array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] =  array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        return array;
    }

    private void swap(int a, int b){
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        int[] arr = {29,10,14,37,14};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        for (int n: arr) {
            System.out.print(n+" ");
        }

    }
}
