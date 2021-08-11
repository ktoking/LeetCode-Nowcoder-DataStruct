package LeetCode.swordToOffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_8_3_21 {

    /**
     * 双指针算法
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if(nums.length==0||nums==null) return new int[0];
        int left=0,right=nums.length-1;
        while (left<right){
            while (left<right&&nums[right]%2==0) right--;
            while (left<right&&nums[left]%2==1) left++;
            int temp=nums[right];
            nums[right]=nums[left];
            nums[left]=temp;
            left++;right--;
        }
        return nums;
    }

    /**
     * 快慢指针算法，首先快指针搜索下一个奇数出现的位置，慢指针指向要交换的位置
     * @param nums
     * @return
     */
    public int[] exchange1(int[] nums) {
        if(nums.length==0||nums==null) return new int[0];
        int fast=0,slow=0;
        while (fast<nums.length){
            if(nums[fast]%2==1){
                int temp=nums[fast];
                nums[fast]=nums[slow];
                nums[slow]=temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
