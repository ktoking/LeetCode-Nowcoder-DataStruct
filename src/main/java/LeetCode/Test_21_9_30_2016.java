package LeetCode;

import java.util.Scanner;

/**
 * 2016. 增量元素之间的最大差值
 * 给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 *
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [7,1,5,4]
 * 输出：4
 * 解释：
 * 最大差值出现在 i = 1 且 j = 2 时，nums[j] - nums[i] = 5 - 1 = 4 。
 * 注意，尽管 i = 1 且 j = 0 时 ，nums[j] - nums[i] = 7 - 1 = 6 > 4 ，但 i > j 不满足题面要求，所以 6 不是有效的答案。
 * 示例 2：
 *
 * 输入：nums = [9,4,3,2]
 * 输出：-1
 * 解释：
 * 不存在同时满足 i < j 和 nums[i] < nums[j] 这两个条件的 i, j 组合。
 * 示例 3：
 *
 * 输入：nums = [1,5,2,10]
 * 输出：9
 * 解释：
 * 最大差值出现在 i = 0 且 j = 3 时，nums[j] - nums[i] = 10 - 1 = 9 。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 2 <= n <= 1000
 * 1 <= nums[i] <= 109
 */
public class Test_21_9_30_2016 {

    public static void main(String[] args) {

    }

    // 暴力枚举
    public int maximumDifference(int[] nums) {
        int max=-1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <nums.length; j++) {
                if(nums[j]>nums[i]){
                    max=Math.max(nums[j]-nums[i],max);
                }
            }
        }
        return max;
    }

//    从最左开始遍历，若右边的数B大于左边的数A，则记录差值，直至遇到更小的数C,此时记录了A到C之间的最大差值；
//    若遇到更小的数C，则再向右遍历到数D时，因为C<A，所以最大的差值一定不是D-A，而是D-C。
//    综上所述，只需要遍历一遍即可，时间复杂度O(n),空间复杂度O(1)

    class Solution {
        public int maximumDifference(int[] nums) {
            int left = 0;
            int right = 1;
            int max = -1;
            while (right < nums.length) {
                if (nums[left] < nums[right]) {
                    max = Math.max(max, nums[right] - nums[left]);
                } else {
                    left = right;
                }
                right++;
            }
            return max;
        }
    }
}
