package BUFFcode.NewCodeTest9;

import java.util.Scanner;

/**
 * 本题难度不大，还是一道经典的数字中找规律的问题。本题的关键就在于是否能想到将任意一个整数分解质
 * 因数来查找规律。
 * 【解题思路】：
 * 任意挑选几个数字进行分解质因数，例如：
 * 6 = 2*3
 * 15 = 3*5
 * 64 = 2*2*2*2*2*2 = 2^6
 * 100 = 2^2 * 5^2
 * 576 = 2^6 * 3^2
 * 那么我们在计算n的阶乘时，实际上就是把所有小于等于n的正整数分解成质因数，然后再将其乘到一起，那
 * 么末尾0的个数实际上就是2*5的个数，而2的个数明显是很多很多的，所以问题就转化成了5的个数。
 * 而只有5的倍数才有5这个因数，所以，问题就进一步简化为小于等于n的数中有多少个数是5的倍数，当然25
 * 的倍数，125的倍数，625还要单独考虑
 */
public class NewNnum0 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int anInt = Integer.parseInt(scanner.nextLine());
        int count=0;
        for (int i = anInt; i >= 5; i--) {
            int temp=i;
            while ((temp%5==0)){
                count++;
                temp/=5;
            }
        }
        System.out.println(count);
    }

}
