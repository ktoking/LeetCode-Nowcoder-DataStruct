package LeetCode;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_7_23__64 {

    /**
     * 动态规划问题，求最优子结构
     * 本题其实与之前机器人走迷宫特别想，只不过这个要求出最短路径，那个是求有几种方法
     *
     * 首先分析，只能从左上到右下的话，那么可以这样想，当我们机器人在第一行的时候，最终是要往最右边走的，当我们在第一列的时候，最终是往下走的
     * 当不在第一行或者第一列，那么我这一步其实可以由上面一步下来，或者从左边一步过来，因为我这个机器人只能这么走嘛，那其实找其中最小的值加上我这一步的值就是我这一步的最小值，那么到最后一步也是前两步的最小值结构
     *
     * i=0 ,j>0 dp[0][j]=dp[0][j-1]+grid[0][j];
     * i>0 ,j=0 dp[i][0]=dp[i-1][0]+grid[i][0];
     * i>0 ,j>0 dp[0][j]=min{dp[i][j-1],dp[i-1][j]}+grid[i][j];
     *
     * 最后返回最右下角的值就是最短路径值
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid.length==0)return 0;
        int row=grid.length;
        int col=grid[0].length;
        int[][] dp=new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i==0&&j==0){
                    dp[0][0]=grid[0][0];
                }
                else if(i==0){
                    dp[0][j]=dp[0][j-1]+grid[0][j];
                }
                else if(j==0){
                    dp[i][0]=dp[i-1][0]+grid[i][0];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
