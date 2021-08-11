package BUFFcode.WrittenTest.W58TongCheng;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=scanner.nextInt();
            }
        }
        int  count=0;
        boolean[][] vis=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]==1){
                    count++;
                    dfs(arr,i,j);
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int[][] arr,int i,int j){
        if(i<0||i>arr.length-1||j<0||j>arr[0].length-1||arr[i][j]==0){
            return;
        }
        arr[i][j]=0;
        dfs(arr,i+1,j);
        dfs(arr,i,j+1);
        dfs(arr,i-1,j);
        dfs(arr,i,j-1);
    }
}
