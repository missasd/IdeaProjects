package algs4.chp1.p2.q1;

public class QuickSort {
    int partition(int a[], int low, int high){
        int key = a[low];
        while (low < high){
            while (low < high && a[high] >= key) high--;
            a[low] = a[high];
            while (low < high && a[low] <= key) low++;
            a[high] = a[low];

        }
        a[low] = key;
        return low;
    }

    public static int getIndex(int[] arr, int low, int high){
        // 基准数据
        int tmp = arr[low];
        while (low < high){
            // 当队尾的元素大于等于基准元素时，向前挪动high指针
            while (low < high && arr[high] >= tmp)
                high--;
            // 如果队尾元素小于tmp了，需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时，向前挪动low指针
            while (low < high && arr[low] <= tmp)
                low++;
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等，此时low或high就是tmp的正确索引位置
        //将tmp赋值给low位置
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            // 寻找基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, low, index-1);
            quickSort(arr, index+1, high);
        }
    }

    public static void main(String[] args) {
        QuickSort quick = new QuickSort();
        int[] arr = {23, 46, 0, 8, 11, 18};
        QuickSort.quickSort(arr, 0, arr.length-1);
        for (int i: arr) {
            System.out.print(i+" ");
        }

    }
}
