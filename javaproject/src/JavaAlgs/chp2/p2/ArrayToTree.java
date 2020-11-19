package JavaAlgs.chp2.p2;

import JavaAlgs.chp2.BiTNode;

public class ArrayToTree {
    public static BiTNode arrtyToTree(int[] arr, int start, int end)
    {
        BiTNode root = null;
        if (end >= start){
            root = new BiTNode();
            int mid = (start + end + 1)/2;
            root.data = arr[mid];
            root.left = arrtyToTree(arr, start, mid-1);
            root.right = arrtyToTree(arr, mid+1, end);
        }
        else {
            root = null;
        }
        return root;
    }

    /**
     * 用中序遍历打印数组
     */
    public static void InOrderTraversal(BiTNode root){
        if (root == null) return;
        if (root.left != null){
            InOrderTraversal(root.left);
        }
        System.out.print(" " + root.data);
        if (root.right != null){
            InOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        BiTNode root;
        root = arrtyToTree(arr, 0, arr.length-1);
        InOrderTraversal(root);
    }
}
