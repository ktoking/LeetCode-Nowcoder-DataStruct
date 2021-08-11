package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Test_12_13__217 {

    /**
     * 炫技,拉跨写法,去重后统计个数,判断与原数组长度是否相同
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums.length==0||nums==null) return false;
        return Arrays.stream(nums).distinct().count()!=nums.length;

    }

    /**
     * set去重法
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        if(nums.length==0||nums==null) return false;
        Set<Integer> set=new HashSet<>();
        for (Integer integer : nums) {
            if(set.contains(integer)) return true;
            set.add(integer);
        }
        return false;
    }

    /**
     * 先排序后比较前后元素是否相同
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
            if(nums.length==0||nums==null) return false;
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if(nums[i]==nums[i-1]) return true;
            }
            return false;
    }
}
