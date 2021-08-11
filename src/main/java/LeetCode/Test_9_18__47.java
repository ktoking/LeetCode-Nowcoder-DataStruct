package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 */
public class Test_9_18__47 {
    List<List<Integer>> lists=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        huisu(new ArrayList<>(),nums,new boolean[nums.length]);
        return lists;
    }
    public void huisu(List<Integer> list,int[] nums,boolean[] vis){
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i]) continue;
            if(i>0&&nums[i-1]==nums[i]&&!vis[i-1]) continue;
            vis[i]=true;
            list.add(nums[i]);
            huisu(list,nums,vis);
            list.remove(list.size()-1);
            vis[i]=false;
        }
    }
}
