package BUFFcode.WrittenTest.BaiDu;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int row = scanner.nextInt();
        for (int i = 0; i < row; i++) {
            int n = scanner.nextInt(); //1-n头奶牛
            int m = scanner.nextInt();// m特性
            int[] arr=new int[n];
            for (int j = 0; j < m; j++) {
                int k = scanner.nextInt(); //区间数量
                for (int l = 0; l < k; l++) {
                    int left=scanner.nextInt();
                    int right=scanner.nextInt();
                    arr[left]=1;
                    if(right-left<=k+1) {
                       get(arr,left,right,j);
                    }else {
                        get(arr,left,left+k-1,j);
                    }
                }
            }
            int count=0;
            StringBuilder sb=new StringBuilder();
            for (int j = 1; j < arr.length; j++) {
                if(arr[j]==1) {
                    count++;
                    sb.append(j+" ");
                }
            }
            System.out.println(count);
            System.out.println(sb.toString());
        }

    }
    public  static void get(int[] arr,int l,int r,int time){
        if(time==0){
            for (int i = l; i<=r; i++) {
                arr[i]=1;
            }
        }else {
            for (int i = 1; i<arr.length; i++) {
                if(i>=l&&i<=r&&arr[i]==1) arr[i]=1;
                else if(i>=l&&i<=r)  arr[i]=0;
                else if(arr[i]==0) arr[i]=1;
             }
        }
    }
}
