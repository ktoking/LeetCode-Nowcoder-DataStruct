package BUFFcode.WrittenTest.DuXiaoMan;



import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] s2 = s1.split(" ");
        boolean flag=false;
        int n = Integer.parseInt(s2[0]);
        int k = Integer.parseInt(s2[1]);
        char[][] arr=new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j]=s.charAt(j);
            }
        }
        int[][]dp=new int[n][n];
        for (int i = 0; i < n; i++) {
            if(flag) break;
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0){
                }else if(i==0){
                    if(arr[i][j]=='#'){
                        dp[i][j]=dp[i][j-1]+k+1;
                    }else if(arr[i][j]=='1'){
                        break;
                    }else {
                        dp[i][j]=dp[i][j-1]+1;
                    }
                }else if(j==0){
                    if(arr[i][j]=='#'){
                        dp[i][j]=dp[i-1][j]+k+1;
                    }else if(arr[i][j]=='1'){
                        break;
                    }else {
                        dp[i][j]=dp[i-1][j]+1;
                    }
                }else if(i!=0&&j!=0){
                    if(arr[i][j]=='#'){
                        if(dp[i-1][j]==0&&dp[i][j-1]==0){
                            flag=true;break;
                        }
                        else if(dp[i-1][j]==0){
                            dp[i][j]=dp[i][j-1]+1+k;
                        }else if(dp[i][j-1]==0){
                            dp[i][j]=dp[i-1][j]+1+k;
                        }else {
                            dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+1+k;
                        }
                    }else if(arr[i][j]=='1'){
                        break;
                    }else {
                        if(dp[i-1][j]==0&&dp[i][j-1]==0){
                            flag=true;break;
                        }
                        else if(dp[i-1][j]==0){
                            dp[i][j]=dp[i][j-1]+1;
                        }else if(dp[i][j-1]==0){
                            dp[i][j]=dp[i-1][j]+1;
                        }else {
                            dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+1;
                        }
                    }
                }
            }
        }
        if(flag){
            System.out.println("No solution");
        }else {
            System.out.println(dp[n-1][n-1]);
        }

    }
}
