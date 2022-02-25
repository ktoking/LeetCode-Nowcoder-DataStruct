package LeetCode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *  
 *
 * 提示：
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_7_6__62 {

    /**
     * 与63题一个类型 dp,但不需要判断障碍
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(m==0||n==0) return 0;
        int arr[][]=new int[m][n]; //dp数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    arr[i][j]=1;    //如果是第一行或第一列,那么都有一种方法可走,所以都是1
                }else {
                    arr[i][j]=arr[i-1][j]+arr[i][j-1]; //如果没有障碍,那么此次数量就等于上边和左边的总数量之和
                }
            }
        }
        return arr[m-1][n-1]; //返回最右总数
    }


    public int uniquePaths1(int m, int n) {
        if(m==0||n==0) return 0;
        int dp[][]=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    dp[i][j]=1;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }


    /**
     * dp
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        if(m==0||n==0)return 1;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){ dp[i][j]=1;continue;}
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


























}
