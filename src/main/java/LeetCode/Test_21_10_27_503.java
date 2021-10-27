package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 */
public class Test_21_10_27_503 {


    /**
     * 单调栈  可以遍历一次数组，如果元素是单调递减的（则他们的「下一个更大元素」相同），我们就把这些元素保存，直到找到一个较大的元素；把该较大元素逐一跟保存了的元素比较，如果该元素更大，那么它就是前面元素的「下一个更大元素」
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements1(int[] nums) {
        int[] rtArr=new int[nums.length];
        Stack<Integer> stack=new Stack<>();
        int n=rtArr.length;
        Arrays.fill(nums,-1);
        for (int i = 0; i < 2*n; i++) {
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i%n]){
                rtArr[stack.pop()]=nums[i%n];
            }
            stack.push(i%n);
        }
        return rtArr;
    }




    /**
     * 暴力 从中间开搜 先搜右边 搜不到再搜左边
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] rtArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int l = 0;
            int r = i + 1;
            int maxL = Integer.MIN_VALUE;
            int maxR = Integer.MIN_VALUE;

            while (r < nums.length) {
                if (nums[r] > nums[i]) {
                    maxR = nums[r];
                    break;
                }
                r++;
            }
            if (maxR > nums[i]) {
                rtArr[i] = maxR;
                continue;
            }

            while (l < i) {
                if (nums[l] > nums[i]) {
                    maxL = nums[l];
                    break;
                }
                l++;
            }

            if (maxL > nums[i]) {
                rtArr[i] = maxL;
                continue;
            } else {
                rtArr[i] = -1;
            }
        }

        return rtArr;
    }
}
