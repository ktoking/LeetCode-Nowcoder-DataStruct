package LeetCode;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class Test_12_11__41 {

    /**
     * 我们将数组中所有小于等于 00 的数修改为 N+1N+1；
     *
     * 我们遍历数组中的每一个数 xx，它可能已经被打了标记，因此原本对应的数为 |x|∣x∣，其中 |\,|∣∣ 为绝对值符号。如果 |x| \in [1, N]∣x∣∈[1,N]，那么我们给数组中的第 |x| - 1∣x∣−1 个位置的数添加一个负号。注意如果它已经有负号，不需要重复添加；
     *
     * 在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1N+1，否则答案是第一个正数的位置加 11。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0||nums==null) return 1;
        int n=nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0) nums[i]= n+1;
        }
        for (int i = 0; i < nums.length; i++) {
           int num=Math.abs(nums[i]);
           if(num<=n){
               nums[num-1]=-Math.abs(nums[num-1]);
           }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}
