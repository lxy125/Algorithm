package Homework2;

import java.util.Arrays;

public class MaxSum {

    public static void main(String[] args) {
        int[] nums = {-2, 11, -4, 13, -5, -2};

        System.out.println("最大连续子数组和为: " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // 初始化动态规划数组 dp，dp[i] 表示以 nums[i] 结尾的最大子数组和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];


        for (int i = 1; i < nums.length; i++) {

            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
             maxSum= Math.max(maxSum, dp[i]);
        }

//
        return maxSum;
    }
}