package LeetCode.swordToOffer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_7_25_14i {
    /**
     * 首先,题目意思就是一段n分几次乘积最大,有规律(自己推两三个数就知道了)可知,分成以3为基数,可得最大乘积
     * @param
     * @return
     */
    public static void main(String[] args) {
        System.out.println(cuttingRope(7));
    }

    /**
     * 绳子段切分的越多，乘积越大，且3做因数比2更优。
     *
     * 不断剪去 长度3 并用sum累乘
     *
     * 把绳子切为多个长度为 3 的片段，则留下的最后一段绳子的长度可能为 0,1,2 三种情况。
     *
     * 循环结束的三种情况：
     *
     *   n=n-3==2
     * n长度剩下2，因 n > 4 跳出循环，return 乘积为sum*2。
     *
     *   n=n-3==3
     * 长度刚好可以被剪完，因 n > 4 跳出循环，return 乘积为sum*3。
     *
     *   n=n-3==4
     * 再剪一次的话，长度剩下1，则最后一段绳子长度为 1； 需要把最后的 3 和 1 替换为 2 和 2，因为 2 * 2 > 3 * 1； 因 n > 4 跳出循环，return 乘积 sum*4 即可。
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if(n<=3) return n-1;
        int sum=1;
        while (n>4){
            sum*=3;
            n-=3;
        }
        return sum*n;
    }

    /**
     * 我们分析一下,如果这个数拆分成一堆3,且余数为0,那就刚好是最大乘积,那么n%3结果只能是0 1 2
     * 如果余数为1 例如 7->3*3*1 那么我们不如把1与一个3取出来,变为2*2,这样就是最大乘积 7-> 3*2*2
     * 如果余数为2 5->3*2 那么我们直接乘这个余数就是最大的乘积
     */
    public static int integerBreak(int n) {
        if(n<=3) return n-1;
        int x=n/3,y=n%3;
        if(y==0) return (int) Math.pow(3,x);
        else if(y==1) return (int) (Math.pow(3,x-1)*4);
        else return (int) (Math.pow(3,x)*y);
    }

}
