package BUFFcode.WrittenTest.QuNaER;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nextInt = Integer.parseInt(scanner.nextLine());
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");
        int[][] dp=new int[ss1.length+1][ss2.length+1];
        for (int i = 0; i < ss1.length ; i++) {
            for (int j = 0; j < ss2.length ; j++) {
                if(ss1[i].equals(ss2[j])){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else {
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        System.out.println(dp[ss1.length][ss2.length]);
    }
}
