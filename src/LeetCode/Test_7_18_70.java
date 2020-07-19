package LeetCode;

/**
 *
 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶
 */
public class Test_7_18_70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    /**
     * 递归,斐波那契数列,n特别大时会超时
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);

    }

    /**
     * 尾递归方式,每次都在尾部进行加和操作
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        return Fibonacci(n,1,1);
    }
    public static int Fibonacci(int n, int a, int b) {
        if (n <= 1)
            return b;
        return Fibonacci(n - 1, b, a + b);
    }

    /**
     * 动态规划,状态转移方程: dp[i]=dp[i-1]+dp[i-2];
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 优化版本,其实我们可以不需要用数组保存那么多的变量,只需知道前两个就可以了,所以我们优化
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
       int first=1; //定义前两个变量
       int second=1;
       while(--n>0){
           second=first+second;
           first=second-first;
       }
       return second;
    }

}
