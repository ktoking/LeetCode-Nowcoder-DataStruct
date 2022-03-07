package LeetCode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 通过次数244,466提交次数447,841
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_7_18__121 {
    public static void main(String[] args) {

    }

    /**
     * 遍历一遍解法
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int maxPro=0;
        for (int price : prices) { //循环数组,找到最小的买入点,与最大的利润点
            if(price<min){
                min=price;          //设置最小的买入点
            }else  {
                 maxPro=Integer.max(maxPro,price-min); //最大的利润值就是用之前的最大利润与今天利润取最大值
            }
        }
        return maxPro;
    }

    /**
     * 动态规划
     * 最大利润=max{前i-1天的最大利润,第i天的价格-第i-1天最小的价格}
     * @param prices
     * @return
     */
    public static int maxProfitDP(int[] prices) {

        int max=0,minVal=Integer.MAX_VALUE;
        for (int price : prices) {
            minVal=Integer.min(price,minVal);
            max=Integer.max(max,price-minVal);
        }
        return max;
    }


    public int maxProfit1(int[] prices) {
        int max=0;
        int low=Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(prices[i], low);
            max= Math.max(max,prices[i]-low);
        }
        return max;
    }



























}
