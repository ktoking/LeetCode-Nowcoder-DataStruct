package BUFFcode.WrittenTest.QiAnXian;

import java.util.Scanner;

/**
 * 背包问题
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int Allcount = scanner.nextInt();
        int n = scanner.nextInt();
        int[] W=new int[n];
        int[] V=new int[n];
        for (int i = 0; i < n; i++) {
            W[i]=scanner.nextInt();
            V[i]=scanner.nextInt();
        }
        int dp[][]=new int[n][Allcount];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= Allcount ; j++) {
                dp[i][j]=dp[i-1][j];
                if(j>=W[i])
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-W[i]]+V[i]);
            }
        }
        System.out.println(dp[n][Allcount]);

//        //完全背包问题
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= Allcount ; j++) {
//                dp[i][j]=dp[i-1][j];
//                if(j>=W[i])
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-W[i]]+V[i]);
//            }
//        }
    }
}
