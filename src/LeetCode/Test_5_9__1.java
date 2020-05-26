package LeetCode;

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
}
