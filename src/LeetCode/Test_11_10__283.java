package LeetCode;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Test_11_10__283 {
    /**
     * 双指针解法,首先利用l r两个指针,l记录要插的地方,r记录要插的数字,当找到不为0的数字的时候就要插入到l的地方,但不管怎么样r都是要走的
     * 最后再覆盖一下0就可以
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if(nums.length<=1||nums==null) return;
        int l=0,r=0;
        while (r<nums.length){
            if(nums[r]!=0){
                nums[l++]=nums[r];
            }
            r++;
        }
        while (l<nums.length) nums[l++]=0;
    }
}
