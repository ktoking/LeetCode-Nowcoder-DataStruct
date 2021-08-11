package LeetCode;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Test_8_7__300 {

    /**
     * 动态规划
     *  dp[i]=Math.max(dp[j]+1,dp[i]); dp[i]>dp[j] j<i
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp,1);
        int count=1;
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            count=Math.max(count,dp[i]);
        }
        return count;
    }

    /**
     * 再写一遍,最长上升子序列
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int dp[]=new int[nums.length];
        Arrays.fill(dp,1);
        int max=1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                   dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }






}