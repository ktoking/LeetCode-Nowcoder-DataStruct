package LeetCode;

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？



网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test_7_6__63 {
    /**
     * 考察动态规划
     * @param args
     */
    public static void main(String[] args) {
        int arr[][]={
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(arr));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(m==0||n==0) return 0; //合理性校验
        int arr[][]=new int[m][n]; //dp数组

        //第一行判断,如果遇到障碍就退出,没遇到就在arr中置1,代表第一种方法
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[0][i]==1){
                break;
            }else {
                arr[0][i]=1;
            }
        }
        //第一列判断,如果遇到障碍就退出,没遇到就在arr中置1,代表第一种方法
        for (int i = 0; i < n; i++) {
            if(obstacleGrid[i][0]==1){
                break;
            }else {
                arr[i][0]=1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==1){
                    arr[i][j]=0; //表示当碰到障碍了,直接设置为0
                }else {
                    arr[i][j]=arr[i-1][j]+arr[i][j-1]; //如果没有障碍,那么此次数量就等于上边和左边的总数量之和
                }

            }
        }

        return arr[m-1][n-1]; //返回最右总数
    }
}
