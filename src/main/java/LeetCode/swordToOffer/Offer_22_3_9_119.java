package LeetCode.swordToOffer;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 剑指 Offer II 119. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 */
public class Offer_22_3_9_119 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curCount = 1;
                while (set.contains(num + 1)) {
                    num++;
                    curCount++;
                }
                max = Math.max(max, curCount);
            }
        }
        return max;
    }
}
