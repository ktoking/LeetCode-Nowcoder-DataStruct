package BUFFcode.NewCodeTest7;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/22948c2cad484e0291350abad86136c3
 * 来源：牛客网
 *
 *  /**
 *      * 求最小公倍数：公式法
 *      * 两个数a,b的最小公倍数是a*b/gcd(a,b)
 *      * 由于两个数的乘积等于这两个数的最大公约数与最小公倍数的积，即（a，b）× [a，b] = a × b
 *      * 所以，求两个数的最小公倍数，就可以先求出它们的最大公约数，然后用上述公式求出它们的最小公倍数。
 *      */

public class CommonMultiple {

    /**
     * 实现最小公倍数其实就是两个数除以最大公约数
     * @param m
     * @param n
     * @return
     */
    public static int lcm(int m,int n){
        return (m*n)/gcd(m,n);
    }

    /**
     * 这边最大公约数使用递归求得
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x,int y){
        if(y==0) return x;
        return gcd(y,x%y);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println( lcm(m,n));
        }
    }
}
