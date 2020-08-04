package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 全排列去重版本
 */
public class Test_8_4__47 {

    List<List<Integer>> listAll=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        quan(nums,0);
        return listAll;
    }

    public void quan(int[] nums,int start){
        if(start==nums.length){
            List<Integer> list=new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            listAll.add(list);
        }else {
            Set<Integer> set=new HashSet<>();
            for (int i = start; i <nums.length ; i++) {
                if(set.contains(nums[i])) continue;
                else set.add(nums[i]);
                swap(nums,i,start);
                quan(nums,start+1);
                swap(nums,i,start);
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
