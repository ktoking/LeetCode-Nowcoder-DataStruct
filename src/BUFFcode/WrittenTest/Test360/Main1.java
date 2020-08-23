package BUFFcode.WrittenTest.Test360;

import java.util.Scanner;

/**
 * 给定一个1到N的排列P1到PN（N为偶数），初始时Pi=i（1≤i≤N），现在要对排列进行M次操作，每次操作为以下两种中一种：
 *
 * ①将排列的第1个数移到末尾；
 *
 * ②交换排列的第1个数与第2个数、第3个数与第4个数、...、第N-1个数与第N个数。
 *
 * 求经过这M次操作后得到的排列。
 *
 *
 *
 * 输入描述
 * 第一行包含两个整数N和M，2≤N，M≤105。
 *
 * 第二行包含M个空格隔开的整数t1到tM，1≤ti≤2。若ti=1，则表示第i次操作为操作①；若ti=2，则表示第i次操作为操作②。
 *
 * 输出描述
 * 输出N个空格隔开的整数，即经过M次操作后得到的排列。
 *
 *
 * 样例输入
 * 4 3
 * 1 2 1
 * 样例输出
 * 2 1 4 3
 *
 * 提示
 * 排列变化过程为：{1 2 3 4}->{2 3 4 1}->{3 2 1 4}->{2 1 4 3}。
 */
public class Main1{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long arr[]=new long[n];
        int opt[]=new int[m];
        for (int i = 0; i < n; i++) {
            arr[i]=i+1;
        }
        for (int i = 0; i < m; i++) {
            opt[i]=scanner.nextInt();
        }
        for (int i = 0; i <opt.length ; i++) {
            if(opt[i]==1){
                long temp=arr[0];
                for (int j = 0; j < n - 1; j++) {
                    arr[j]=arr[j+1];
                }
                arr[n-1]=temp;
            }else {
                for (int j = 0; j < arr.length-1; j++) {
                    if(j%2==0){
                        arr[j]=arr[j]+arr[j+1];
                        arr[j+1]=arr[j]-arr[j+1];
                        arr[j]=arr[j]-arr[j+1];
                    }
                }
            }
        }
        for (long i : arr) {
            System.out.printf("%d ",i);
        }
    }
}
