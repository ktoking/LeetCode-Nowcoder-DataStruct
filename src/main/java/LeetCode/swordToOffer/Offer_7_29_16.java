package LeetCode.swordToOffer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_7_29_16 {


    /**
     * 快速幂，首先处理特殊情况与-数的情况
     *
     * 快速幂
     *          pow(返回值) x   n
     * 3^5 ->    1          3   5
     *           3          9   2
     *           3          81  1
     *           9*81       81  0
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(x==1) return 1;
        long nl=n;
        double pow=1;
        if(nl<0){
            x=1/x;
            nl=-1*nl;
        }
        while (nl>0){
            if(nl%2==1){
                pow*=x;
            }
            x*=x;
            nl>>=1;
        }
        return pow;
    }
}
