package LeetCode.swordToOffer;

public class Offer_9_15_43 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(12));
    }

    /**
     * 超时,他妈的,艹
     * @param n
     * @return
     */
    public static int countDigitOne(int n) {
        int count=0;
        for (int i = 1; i <= n; i++) {
            int num=i;
            while (num!=0){
                if(num%10==1){
                    count++;
                }
                num/=10;
            }
        }
        return count;
    }

    /**
     * 这类题就找规律,跟懂不懂没关系,可以跳过了
     * @param n
     * @return
     */
    public int countDigitOne1(int n) {
        int count = 0;
        long i = 1;        // 从个位开始遍历到最高位
        while(n / i != 0) {
            long high = n / (10 * i);  // 高位
            long cur = (n / i) % 10;   // 当前位
            long low = n - (n / i) * i;
            if(cur == 0) {
                count += high * i;
            }else if(cur == 1) {
                count += high * i + (low + 1);
            }else {
                count += (high + 1) * i;
            }
            i = i * 10;
        }
        return count;
    }
}
