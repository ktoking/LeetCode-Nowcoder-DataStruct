package LeetCode;

import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_6_12__15 {

    /**
     * 先排序数组,然后两个指针从头和尾以此相加比较是不是第一个数的相反数,如果大了,右指针向左移动一次,如果小了,左指针向右移动一次,直到左指针大于右指针结束
     *
     * 注意条件,不能重复解,那我们每找到一次就跳过左右指针相同的数字即可
     * 但是也要注意第一个数字的重复校验
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  //首先排序数组
        List<List<Integer>> lists=new ArrayList<>(); //题解list
        if(nums.length<3) return lists; //如果数组长度不符合直接返回
        for (int i = 0; i < nums.length; i++) { //首先外层循环代表第一个数
            if(i>0&&nums[i]==nums[i-1]) continue; //第一个数字的重读校验
            int target=-nums[i];        //首先找到第一个数的相反数
            int left=i+1;               //代表第二个数字即左指针
            int right=nums.length-1;    //代表第三个数字即右指针
            while (left<right){        //循环结束条件
                if(nums[left]+nums[right]==target){ //如果找到相等的值
                    List<Integer>list=new ArrayList<>();    //结果集
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    left++;right--;         //左右指针移动
                    while (left<nums.length&&nums[left]==nums[left-1]) left++ ; //代表跳过左右指针的重复的数字(保证数组不越界)
                    while (right>left&&nums[right]==nums[right+1]) right--;
                }else if(nums[left]+nums[right]>target){    //如果大于想要的值,那我们就将右指针向左移动一次
                    right--;
                }else left++;                                //相同,如果小于我们要的值.那就左指针向右移动
            }
        }
        return lists;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        if(nums.length<3) return lists;
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            int l=i+1,r=nums.length-1;
            while (l<r){
                if(nums[l]+nums[r]==-nums[i]){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[r]);
                    list.add(nums[l]);
                    lists.add(list);
                    l++;r--;
                    while (l<r&&nums[l-1]==nums[l]) l++;
                    while (r>l&&nums[r+1]==nums[r]) r--;
                }else if(nums[l]+nums[r]>-nums[i]){
                  r--;
                }else l++;
            }
        }
        return lists;
    }
}
