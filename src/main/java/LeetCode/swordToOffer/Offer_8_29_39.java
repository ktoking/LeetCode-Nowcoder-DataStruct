package LeetCode.swordToOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 *
 *
 * 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 *
 *
 */
public class Offer_8_29_39 {

    /**
     * 摩尔投票法,相同就继续+1,不相同就同归于尽
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int res=0,vote=0;
        for (int num : nums) {
            if(vote==0)res=num;
            vote+=num==res?1:-1;
        }
        return res;
    }

    /**
     * 排序取中位数
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * hash法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if(nums.length==1) return nums[0];
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
                if( map.get(num)>nums.length/2) return num;
            }else {
                map.put(num,1);
            }
        }
        return -1;
    }

}
