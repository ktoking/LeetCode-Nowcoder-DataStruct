package LeetCode;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class Test_11_2__718 {
    /**
     * 画表,  3 2 1 4 5 6
     *      1 0 0 1 0 0 0
     *      2 0 1 0 0 0 0
     *      3 1 0 0 0 0 0
     *      4 0 0 0 1 0 0
     *      5 0 0 0 0 2 0
     *      6 0 0 0 0 0 3
     *      选出最大的一步就可
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
        int[][] dp=new int[A.length+1][B.length+1];
        int res=0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                res=Math.max(dp[i][j],res);
            }
        }
       return res;
    }
}
