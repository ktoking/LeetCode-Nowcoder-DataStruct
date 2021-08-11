package BUFFcode.WrittenTest.QiAnXian;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        /**
         * dp方程：dp[i] += dp[i - coin];
         */
        for(int j=1;j<=n;j++) {
            for(int i = j; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - j]);
            }
        }
        System.out.println(dp[n]);
    }
}
