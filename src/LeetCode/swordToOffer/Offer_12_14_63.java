package LeetCode.swordToOffer;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 10^5
 *
 *
 *
 * 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Offer_12_14_63 {

    /**
     * 维护一个最小的值,那我最大的利润肯定是取每次的赚的利润的最小值,那我就要记录每次的最小值就OK
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int maxVal=Integer.MIN_VALUE,min=prices[0];
        for (int price : prices) {
            if(price<min){
                min=price;
            }else {
                maxVal=Math.max(maxVal,price-min);
            }
        }
        return maxVal;
    }
}
