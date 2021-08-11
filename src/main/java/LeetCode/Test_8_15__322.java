package LeetCode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class Test_8_15__322 {

    /**
     * https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
     * 动态规划,从底向上
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0) return -1; //返回不合理
        int dp[]=new int[amount+1]; //dp[i]表示: 构成i的最小硬币数量
        Arrays.fill(dp,amount+1); //因为最小硬币都是1了,我们设置不合理值用来在最后返回-1
        dp[0]=0; //设置初值,面额0不需要硬币构成
        //dp[i]=min{dp[i-coin[0]],dp[i-coin[1]],dp[i-coin[2]].....}
        for (int i = 1; i <= amount; i++) { //上层循环代表dp[i]的取最小硬币
            for (int coin : coins) {        //里层循环代表每次循环判断最小硬币数量是哪个
                if(i-coin<0) continue;      //如果不合理就下一个
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
                // 例如硬币数为 1 , 2
                // dp[4] 可以选4个1 也可以选2 个 2,也可以选 2个1一个2,明显两个2数量小 +1是选择了当前面值的硬币就+1
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
