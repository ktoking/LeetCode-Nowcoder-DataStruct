package BUFFcode.WrittenTest.DongFangCaiFu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String next = scanner.next();
        int[] dp=new int[next.length()+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= next.length(); i++) {
            String substring = next.substring(i - 2, i); //前闭后开区间
            if(substring.compareTo("10")>=0&&substring.compareTo("25")<=0){
                dp[i]=dp[i-1]+dp[i-2];
            }else {
                dp[i]=dp[i-1];
            }
        }
        System.out.println(dp[next.length()]); }
    }

