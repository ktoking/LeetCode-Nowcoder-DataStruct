package BUFFcode.WrittenTest.DaJiang;

import java.util.Scanner;

public class Main1 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int N = sc.nextInt(); //种类
            int T = sc.nextInt(); //钱
            int[] v=new int[N];
            int[] l=new int[N];
            int[] c=new int[N];
            for (int j = 0; j < N; j++) {
                v[j]=sc.nextInt();
                l[j]=sc.nextInt();
                c[j]=sc.nextInt();
            }
            System.out.println(Demo(N,T,l,v,c));
        }

        public static int Demo(int N,int T,int[] l, int[] v,int[] c) {
            int[][] dp = new int[N][T+1];
            for(int i = 1 ; i < T+1 ; i++)
                for(int k = 0 ; k <= c[0] ; k++) {
                    if(i > k*c[0]) {
                        dp[0][i] = k*v[0];
                    }
                }

            for(int i = 1; i < N ; i++) {
                for(int j = 0 ; j < T+1 ; j++) {
                    dp[i][j] = dp[i-1][j];
                    for(int k = 0 ; k <= c[i] ; k++) {
                        if(j >= k*l[i]) {
                            dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*l[i]]+k*v[i]);
                        }
                    }
                }
            }
            return dp[N-1][T];
        }

}
