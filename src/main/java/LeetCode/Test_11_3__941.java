package LeetCode;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class Test_11_3__941 {
    /**
     * 爬山问题,双指针问题,首先l上山然后r上山,若符合条件就++,最后判断是否为同一个山顶就行了
     * 注意若是连续递增或递减也需要判断
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        if(A.length<=0||A==null) return false;
        int l=0,r=A.length-1;
        while (l<r&&A[l+1]>A[l])l++;
        while (r>l&&A[r-1]>A[r])r--;
        return l!=0&&r!=A.length-1&&l==r?true:false;
    }
}
