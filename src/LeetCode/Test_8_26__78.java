package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Test_8_26__78 {

    /**
     * 迭代枚举
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length==0) return new ArrayList<>();
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<>());//把空的加进去了;
        for (int i = 0; i < nums.length; i++) {
            int size=lists.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(lists.get(j));//list深复制,所以得重新new一个才行,不然所有的都会改变
                list.add(nums[i]);
                lists.add(list);
            }
        }
        return lists;
    }

    /**
     * 递归枚举
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>>lists=new ArrayList<>();
        lists.add(new ArrayList<>());
        get(nums,0,lists);
        return lists;
    }
    public static void get(int[] nums,int index,List<List<Integer>> lists){
        if(index>=nums.length) return;
        int size=lists.size();
        for (int i = 0; i < size; i++) {
            List<Integer> list=new ArrayList<>(lists.get(i));
            list.add(nums[index]);
            lists.add(list);
        }
        get(nums,index+1,lists);
    }

    /**
     * DFS，前序遍历
     */
    public static void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        // 到了新的状态，记录新的路径，要重新拷贝一份
        subset = new ArrayList<Integer>(subset);

        // 这里
        res.add(subset);
        preOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        preOrder(nums, i + 1, subset, res);
    }



     static List<List<Integer>> lists=new ArrayList<>();
    /**
     * https://leetcode-cn.com/problems/subsets/solution/hui-su-si-xiang-tuan-mie-pai-lie-zu-he-zi-ji-wen-t/
     * 回溯法大全 子集
     */
    public static List<List<Integer>> subsets12(int[] nums) {
        List<Integer> list=new ArrayList<>();
        huisu(nums,0,list);
        return lists;
    }
    public static void huisu(int[] nums,int index,List<Integer>list){
        lists.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            huisu(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int nums[]=new int[]{1,2,3};
        System.out.println(subsets12(nums));
    }
}
