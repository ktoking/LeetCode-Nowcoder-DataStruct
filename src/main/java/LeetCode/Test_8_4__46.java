package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 全排列不去重
 */
public class Test_8_4__46 {
    /**
     * 经典做法全排列
     */
    List<List<Integer>> listAll=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
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
        }
        for (int i = start; i <nums.length ; i++) {
            swap(nums,i,start);
            quan(nums,start+1);
            swap(nums,i,start);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    /**
     * 回溯模板全排列 没有重复数字
     */
    List<List<Integer>> lists=new ArrayList<>();
    public List<List<Integer>> permute1(int[] nums) {
        huisu(nums,new ArrayList<>());
        return lists;
    }
    public void huisu(int[] nums,List<Integer>list){
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]))continue;
            list.add(nums[i]);
            huisu(nums,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = permute22(new int[]{1, 2, 3});
        System.out.println(1);
    }

    /**
     * 回溯模板再写一遍,使用记录数组区分
     */
    static List<List<Integer>> listAll1=new ArrayList<>();
    public static List<List<Integer>> permute2(int[] nums) {
        boolean[] vis=new boolean[nums.length];
        huisu1(nums,new ArrayList<>(),vis);
        return listAll1;
    }
    public static void huisu1(int[] nums,List<Integer>list,boolean[] vis){
        if(list.size()==nums.length) {
            listAll1.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i]) continue;
            vis[i]=true;
            list.add(nums[i]);
            huisu1(nums,list,vis);
            list.remove(list.size()-1);
            vis[i]=false;
        }
    }


    static List<List<Integer>> listAll11=new ArrayList<>();
    public static List<List<Integer>> permute22(int[] nums) {
        boolean[] vis=new boolean[nums.length];
        huisu11(nums,new ArrayList<>(),vis);
        return listAll11;
    }
    public static void huisu11(int[] nums,List<Integer>list,boolean[] vis){
        if(list.size()==nums.length){
            listAll11.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i]) continue;
            vis[i]=true;
            list.add(nums[i]);
            huisu11(nums,list,vis);
            list.remove(list.size()-1);
            vis[i]=false;
        }
    }



}
