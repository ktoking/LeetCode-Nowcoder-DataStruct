package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Test_8_26__90 {
    /**
     * 去重子集问题 回溯法
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);
        get(nums,0,new ArrayList<>(),lists);
        return lists;
    }
    public static void get(int[] nums,int index,List<Integer>list,List<List<Integer>> lists){
        lists.add(new ArrayList<>(list));
        for (int i = index; i <nums.length; i++) {
            if(i>index&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            get(nums,i+1,list,lists);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{2,2,2}));
    }
}
