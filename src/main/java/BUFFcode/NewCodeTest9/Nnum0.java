package BUFFcode.NewCodeTest9;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/6ffdd7e4197c403e88c6a8aa3e7a332a
 * 来源：牛客网
 *
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 *
 * 输入描述:
 * 输入为一行，n(1 ≤ n ≤ 1000)
 *
 *
 * 输出描述:
 * 输出一个整数,即题目所求
 * 示例1
 * 输入
 * 10
 * 输出
 * 2
 *
 * 时间复杂度大暴力解法
 */
public class Nnum0 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int nextInt = Integer.parseInt(sc.nextLine());
            Nnum0 nnum0=new Nnum0();
            int count=0;
            Long nnumber = nnum0.getNnumber(nextInt);
            while(nnumber%10==0){
                count++;
                nnumber=nnumber/10;
            }
            System.out.println(count);
        }

    }

    public Long getNnumber(int n){
        if(n==1) return 1L;
        else return n*getNnumber(n-1);
    }
}
