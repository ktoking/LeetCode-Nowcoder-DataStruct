package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *
 *
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 */
public class Test_21_10_26_496 {


    /**
     * 暴力双循环 先将数据存到map 双循环查找下一个大的数
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> valMap=new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            for (int j = i+1; j <= nums2.length-1 ; j++) {
                if(nums2[j]>nums2[i]){
                    valMap.put(nums2[i],nums2[j]);
                    break;
                }
            }
        }
        int[] arr3=new int[nums1.length];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i]=valMap.get(nums1[i])==null?-1:valMap.get(nums1[i]);
        }
        return arr3;
    }


    /**
     * 单调栈!! num1 4 3  num2 1234  ->{ 1入栈 2判断当前栈不为空 比1大 valmap记录一下并出栈 再把2入栈}
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer,Integer> valMap=new HashMap<>();
        Stack<Integer> stack=new Stack<>();

        for (int num : nums2) {

            while (!stack.isEmpty()&&stack.peek()<num){
                valMap.put(stack.pop(),num);
            }

            stack.push(num);
        }

        int[] arr3=new int[nums1.length];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i]=valMap.getOrDefault(nums1[i],-1);
        }
        return arr3;
    }


}
