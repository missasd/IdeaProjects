package DesignPattern.Builder.Factory.factory1;

public class Solution {
    public static int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        for (int i=0; i < nums.length-1; i++){
            if (nums[i] > target) continue;
            for (int j = i; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        for (int i : res){
            System.out.print(i + " ");
        }


    }
}
