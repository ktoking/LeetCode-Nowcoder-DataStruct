package LeetCode;

/**
 * 33. 搜索旋转排序数组
 * 给你一个升序排列的整数数组 nums ，和一个整数 target 。
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 */
public class Test_11_12__33 {

    /**
     * 二分法解决问题
     * 首先数组部分有序
     * 那么我们可以用数组最左边元素来判断哪部分有序
     * 比如 6712345 6>nums[mid](2) 所以mid右边有序
     * 要是这时候我们要查的target在数组右边，那么直接根据二分来查找
     * l=mid+1
     * 要是还是在左边 671 查找7那就让r一直减少逐个对比
     *
     * 反之如果数组左边有序，跟上面反着来就行
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length==0||nums==null) return -1;
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target) return mid;
            else if(nums[l]<=nums[mid]){
                if(target>=nums[l]&&target<=nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                if(target>=nums[mid]&&target<=nums[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
