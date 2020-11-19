package exam.jianhang.test1;

import java.util.*;

public class Solution {

    public int uniqueAward (int[] nums) {
        // write code here
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if (set.contains(i)){
                set.remove(i);
            }else {
                set.add(i);
            }
        }
        int result = 0;
        for (int i : set){
            result = i;
        }
        return result;

    }

    public static int kthSmallest (int[][] matrix, int m) {
        // write code here
        int num = (int)Math.ceil(Math.sqrt(m));
        int index = m - (num-1)*(num-1);
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < num; j++){
            list.add(matrix[num-1][j]);
        }

        for (int i = 0; i < num -1; i++) {
            list.add(matrix[i][num-1]);
        }
        Collections.sort(list);
        int result = list.get(index - 1);
        return result;
    }

    public static void main(String[] args) {
        //System.out.println((int)Math.ceil(Math.sqrt(8)));
        int[][] matrix = {{1,5,8},{3,6,9}, {7,10,13}};
        int m = 8;
        System.out.println(kthSmallest(matrix, m));
    }
}
