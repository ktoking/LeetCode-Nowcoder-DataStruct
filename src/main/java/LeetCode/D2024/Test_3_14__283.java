package LeetCode.D2024;

import java.util.HashMap;
import java.util.Map;

/**
 * 283. 移动零
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 */
public class Test_3_14__283 {


    public void moveZeroes(int[] nums) {
        if(nums.length==0) return;
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0) nums[j++]=nums[i];
        }
        for (int i = j; i < nums.length ; i++) {
            nums[i]=0;
        }
    }

}
