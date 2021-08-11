package LeetCode.swordToOffer;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 */
public class Offer_12_9_56i {

    /**
     * 找出不同的两个数 -> 按位来找肯定有一位不相同 ,所以我们先异或所有的数字,不同两个数异或为1 我们就需要按照那位1来区分,只要把出现一次的数字分到相同划分区间就可以异或来找到他
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        if(nums==null||nums.length==0) return new int[]{};
        int k=0;
        for (int num : nums) {
            k^=num;
        }
        int mask=1;
        while ((mask&k)==0){
            mask<<=1;
        }
        int a=0,b=0;
        for (int num : nums) {
            if((num&mask)==0){
                a^=num;
            }else {
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}
