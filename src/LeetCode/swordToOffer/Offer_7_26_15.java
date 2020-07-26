package LeetCode.swordToOffer;

public class Offer_7_26_15 {
    public int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            count+=n&1;  //只有最后一位是1的与1才为1,0与1为0,那么我们不断与1,然后右移一位就能求出
            n>>>=1;
        }
        return count;
    }

    /**
     * 利用 n&(n-1)特性
     * 初始化数量统计变量 res 。
     * 循环消去最右边的 1 ：当 n = 0 时跳出。
     * res += 1 ： 统计变量加 1 ；
     * n &= n - 1 ： 消去数字 n 最右边的 1 。
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
