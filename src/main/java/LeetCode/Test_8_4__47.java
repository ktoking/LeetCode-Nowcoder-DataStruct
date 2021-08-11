package LeetCode;

import java.util.*;

/**
 * 47. 全排列重复数字 II
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


    /**
     * 全排列模板重复数字
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;
    }
    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, path, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }

}
