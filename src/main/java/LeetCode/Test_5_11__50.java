package LeetCode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
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
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 
 */
public class Test_5_11__50 {
    public static void main(String[] args) {
        double value = Test_5_11__50.myPow(2, -2);
        System.out.println(value);
    }

    public static double myPow(double x, int n) {
        long N=n;
        return n>=0? quickM(x,N):1.0/quickM(x,-N);
    }
    public static double quickM(double x, long n) {
       if(n==0) return 1; //递归结束条件
       double v = myPow(x, (int) (n / 2));
       if(v%2==0){
           return v*v;
       }else {
           return v*v*x;
       }
    }
}
