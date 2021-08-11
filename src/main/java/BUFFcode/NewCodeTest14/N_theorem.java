package BUFFcode.NewCodeTest14;

import java.util.Scanner;

/**
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 */
public class N_theorem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(GetSequeOddNum(scanner.nextInt()));
        }
    }

    /**
     * 找出规律,首项公式为:m*(m-1)+1
     * @param m
     * @return
     */
    public static String GetSequeOddNum(int m)
    {
        StringBuilder sb=new StringBuilder();
        if(m>0){
            int sum=m*(m-1)+1;
            for (int i = 1; i <= m; i++) {
                if(i==m){
                    sb.append(sum);
                }else {
                    sb.append(sum+"+");
                }
                sum+=2;
            }
        }

        return sb.toString();
    }
}
