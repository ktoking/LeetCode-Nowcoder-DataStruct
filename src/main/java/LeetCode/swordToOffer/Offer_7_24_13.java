package LeetCode.swordToOffer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_7_24_13 {
    public static void main(String[] args) {
        System.out.println(movingCount(16,16,2));
    }
    /**
     * dfs，分析可知，只能从左上角走到右下角，那么不用双重for进行遍历整个数组
     * 老套路：当ij>0的时候每一步，都可以由上一步或者左边一步过来，那么当前总数量就是1（代表当前格子）+下一步的格子+右边步的格子递归下去
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCount(int m, int n, int k) {
        boolean vis[][]=new boolean[m][n];
        return dfs(0,0,m,n,k,vis);
    }
    public static int dfs(int i,int j,int m,int n,int k,boolean[][] vis ){
        if(i>m-1||j>n-1||get(i)+get(j)>k||vis[i][j]) return 0;
        vis[i][j]=true;
        return 1+dfs(i+1,j,m,n,k,vis)+dfs(i,j+1,m,n,k,vis);
    }
    public static int get(int num){
        int sum=0;
        while (num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
