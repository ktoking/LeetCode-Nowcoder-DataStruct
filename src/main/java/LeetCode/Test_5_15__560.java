package LeetCode;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_5_15__560 {
    public static void main(String[] args) {
        int []nums={2,1,2,1,4,4,1,2};
        System.out.println(subarraySum(nums,3));
    }

    /**
     * 解法1,暴力遍历解法,双重for循环
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j >=0 ; j--) {
                sum+=nums[j];
                if(sum==k) count++; //这里不考虑break,因为可能有0值或负数存在
            }
        }
        return count;
    }
}
