package LeetCode.D2024;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法三：一遍哈希表
 * 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
 *
 * Java
 * class Solution {
 *     public int[] twoSum(int[] nums, int target) {
 *         Map<Integer, Integer> map = new HashMap<>();
 *         for (int i = 0; i < nums.length; i++) {
 *             int complement = target - nums[i];
 *             if (map.containsKey(complement)) {
 *                 return new int[] { map.get(complement), i };
 *             }
 *             map.put(nums[i], i);
 *         }
 *         throw new IllegalArgumentException("No two sum solution");
 *     }
 * }
 *
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Test_5_9__1 {

    public static void main(String[] args) {
        int []nums = {3,2,4};
        int[] ints = Test_5_9__1.twoSum1(nums, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    //暴力法
    public static int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length-1 ; j++) {
                if(nums[i]+nums[j]==target){
                    arr[0]=nums[i];
                    arr[1]=nums[j];
                }
            }
        }
        return arr;
    }

    /**
     * hash表来实现一次遍历
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target){
        Map<Integer,Integer> map= new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int compeletment=target-nums[i];
            if(map.containsKey(compeletment)){
                return new int[]{map.get(compeletment),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 再写一遍
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum11(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap(); //用hashmap将值与下标联合起来
        for (int i = 0; i < nums.length; i++) { //每进行一次遍历,我们取出数组中的值,我们将target减去数组的值作为key,看map中有没有存在
            int com=target-nums[i];
            if(map.containsKey(com)){   //如果包含,加入到数组中
                return new int[]{map.get(com),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 再写一遍
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum111(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }




    public int[] twoSum1111(int[] nums, int target) {
        Map<Integer,Integer> data=new HashMap<>();
        int[] ints = new int[2];
        for (int i = 0; i < nums.length ; i++) {
            if(data.get(nums[i])!=null){
                ints[0]=data.get(nums[i]);
                ints[1]=i;
                return ints;
            }else {
                data.put(target-nums[i],i);
            }
        }
        return ints;
    }


    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     */

    static class Solution {
        public  int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
               if(map.containsKey(nums[i])){
                   return new int[]{i,map.get(nums[i])};
               }
               map.put(target-nums[i],i);
            }
            return new int[]{};
        }
    }






























}
