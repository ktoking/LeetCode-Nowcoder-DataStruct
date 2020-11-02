package LeetCode.swordToOffer;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_9_8_42 {

    /**
     * 连续数组最大和优化
     * @param nums
     * @return
     */
    public int maxSubArray11(int[] nums) {
        int cur=0;
        int max=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(cur<0){
                cur=nums[i];
            }else {
                cur+=nums[i];
            }
            max=Math.max(cur,max);
        }
        return max;
    }

    /**
     * 常规动态规划,如果dp[i-1]<=0 那么对dp[i]产生负贡献 那么还不如直接用dp[i]
     * 如果dp[i-1]>0 那么对dp[i]产生正贡献 ,那么dp[i]=dp[i-1]+nums[i]
     * 然后每次取最大值就行了
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1]<=0){
                dp[i]=nums[i];
            }else {
                dp[i]=dp[i-1]+nums[i];
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }

    /**
     * 优化dp结果
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i]+=Math.max(nums[i-1],0);
            max=Math.max(max,nums[i]);
        }
        return max;
    }

        public int maxSubArray(int[] nums) {
            if(nums==null||nums.length==0)return 0;
            int cur=0,max=nums[0];
            for (int i = 0; i < nums.length; i++) {
                if(cur<0){
                    cur=nums[i];
                }else {
                    cur+=nums[i];
                }
                max=Math.max(cur,max);
            }
            return max;
        }
}
