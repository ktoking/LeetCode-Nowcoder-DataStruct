package LeetCode.D2024;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 128. 最长连续序列
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
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
 */
public class Test_3_14__128 {
    public static void main(String[] args) {
        longestConsecutive(new int[]{1, 2, 0, 1});
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 0) return 0;
        int[] distinctSortedNums = Arrays.stream(nums)
                .distinct() // 去重
                .sorted() // 排序
                .toArray();
        int num = 1;
        int max = 1;
        for (int i = 1; i < distinctSortedNums.length; i++) {
            if (distinctSortedNums[i - 1] + 1 == distinctSortedNums[i]) {
                num++;
            } else {
                num = 1;
            }
            max = Integer.max(max, num);
        }
        return max;
    }

    /**
     * hash表
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive1(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
                .boxed() // 将基本类型流转换为包装类型流
                .collect(Collectors.toSet());
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(++num)) count++;
                max = Math.max(count, max);
            }
        }
        return max;
    }

}
