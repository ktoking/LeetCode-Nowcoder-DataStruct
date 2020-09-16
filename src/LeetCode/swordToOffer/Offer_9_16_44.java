package LeetCode.swordToOffer;

/**
 * c
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 *
 *
 * 限制：
 *
 * 0 <= n < 2^31
 * 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
 */
public class Offer_9_16_44 {

    /**
     * 自己写的永远超时
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <=n ; i++) {
            sb.append(i+"");
        }
        return Integer.parseInt(sb.toString().charAt(n)+"");
    }


    /** 范围      位数      个数       位数
     *  0-9         1         9         9
     *  10-99       2        90         180
     *  100-999     3        900        1800
     *   例如 2901 = 9 + 180 + 2700 + 12 即一定是4位数,第12位   n = 12;
     *   数据为 = 1000 + (12 - 1)/ 4  = 1000 + 2 = 1002
     *   定位1002中的位置 = (n - 1) %  4 = 3    s.charAt(3) = 2;
     */
    public int findNthDigit1(int n) {
        int dig=1;
        long start=1;
        long weishu=9;
        while (n>weishu){
            n-=weishu;
            dig++;
            start*=10;
            weishu=dig*start*9;
        }
        long num=start+(n-1)/dig;
        return Long.toString(num).charAt((n-1)%dig)-'0';
    }
}
