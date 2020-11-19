package algs4.chp1.p2.q3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // 切分
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi)
    { // 以a[i]，为切割点将数组切分为 三部分
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo]; // 切分元素
        while (true)
        {  // 扫描左右,检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if ( i >= j) break;

        }
        exch(a, lo, j);  // 将v = a[j] 放入正确的位置
        return j;

    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t;}

    private static void show(Comparable[] a)
    {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        // 测试数组是否有序
        for (int i = 1; i < a.length ; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }
}
