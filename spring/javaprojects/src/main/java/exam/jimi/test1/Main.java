package exam.jimi.test1;

import leetcode.num.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int maxSubArrayProduct (int[] nums) {
        // write code here
//        int i = 0;
//        int j = 0;
        int n = nums.length;
        int max = nums[0];
        if (n == 1) return max;
        int[][] dp = new int[n][n];
        // 初始化
        for (int i = 0; i < n; i++){

                dp[i][i] = nums[i];

        }

        for (int j = 0; j < n; j++){
            for (int i = 0; i < j; i++){
                if (j == i) {
                    continue;
                }else {
                    int a = dp[i][j-1] * nums[j];
                    int b = dp[i][j-1];
                    int c = nums[j];
                    if (nums[j] < 0){
                        dp[i][j] = b;
                    }else {
                        dp[i][j] = Math.max(a, Math.max(b, c));
                    }

                }
                max = Math.max(max, dp[i][j]);
            }
        }



        return max;
    }

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode curr = head;
        while (curr != null && curr.next != null && curr.next.next != null){
            ListNode tmp = curr;
            while (curr.val == curr.next.val){
                tmp = tmp.next;
            }
        }
        return null;
    }
}
