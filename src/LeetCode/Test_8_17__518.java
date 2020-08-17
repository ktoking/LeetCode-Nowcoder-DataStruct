package LeetCode;

/**
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 */
public class Test_8_17__518 {

    /**
     * 动态规划
     * 类似于完全背包问题 只不过完全背包问题是小于等于背包容量且拿到价值的最大值
     * 而这个是硬币金额=拿到所有coins的硬币金额的总和情况
     * dp[i]=dp[i]+dp[i-coin]; 钱总数amount=背包容量 coins种类代表物品数 coins的每个金额代表每个物品的体积
     * 套用完全背包问题解决问题
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if(i>=coin){
                    dp[i]=dp[i]+dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
}
