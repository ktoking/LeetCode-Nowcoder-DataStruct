package LeetCode;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class Test_8_26__491 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{4,6,1,1});
        System.out.println(subsets);
    }

    /**
     * 回溯法经典模板改
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }
    private static void backtrack(int index, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if(tmp.size()>1)res.add(new ArrayList<>(tmp)); //只有长度大于等于2才加进去
        Set<Integer> set=new HashSet<>(); //判断去重
        for (int j = index; j < nums.length; j++) {
            if(set.contains(nums[j])||tmp.size()>0&&tmp.get(tmp.size()-1)>nums[j]) continue; //如果加进去的大于之前添加的才可以走下一步
            set.add(nums[j]);
            tmp.add(nums[j]);
            backtrack(j+1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        huisu(nums,0,new ArrayList<Integer>(),res);
        return res;
    }
    public void huisu(int[]nums, int index, List<Integer> collect,List<List<Integer>> res){
        if(collect.size()>1){
            res.add(new ArrayList<>(collect));
        }
        Set<Integer> set=new HashSet<>(); //判断去重
        for (int i = index; i < nums.length ; i++) {
            if(set.contains(nums[i])||collect.size()>0&&collect.get(collect.size()-1)>nums[i]) continue;
            set.add(nums[i]);
            collect.add(nums[i]);
            huisu(nums,i+1,collect,res);
            collect.remove(collect.size()-1);
        }
    }



}
