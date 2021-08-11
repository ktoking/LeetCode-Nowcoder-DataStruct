package BUFFcode.WrittenTest.BianLiFeng;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nextInt = scanner.nextInt();
        String next = scanner.next();
        String[] split = next.split(",");
        int arr[]=new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i]=Integer.parseInt(split[i]);
        }
        System.out.println(buy(nextInt,arr));
    }
    public static int buy(int money, int[] items) {
        int[] dp=new int[money+1];
        dp[0]=1;
        for (int coin : items) {
            for (int i = 1; i <= money; i++) {
                if(i>=coin){
                    dp[i]=dp[i]+dp[i-coin];
                }
            }
        }
        return dp[money];
    }
}
