package BUFFcode.WrittenTest.MeiTuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * /**
 *  * 5
 *  * 3 2 4 4 5
 *  * 4 3 5 2 1
 *  * Exception in
 *  */

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]=new int[n];//货物重量
        int opt[]=new int[n];//去除顺序
        List<Integer> listarr=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            arr[i]=scanner.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            opt[i]=scanner.nextInt();
        }
        int two[][]=new int[n][n];
        for (int i = 0; i < two.length; i++) {
            for (int j = 0; j < two[0].length; j++) {
                two[i][j]=arr[j];
            }
            if(getIndex(two[i],opt[i])!=-1){
                two[i][getIndex(two[i],opt[i])]=-1;
            }
            System.out.println(get(two[i]));
        }
    }

    public static int getIndex(int[] arr,int k){
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if(count==k) return i;
            else if(arr[i]==-1) continue;
            else count++;
        }
        return -1;
    }

    public static int get(int[]arr){
        int max=0;
        int coun=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=-1){
                coun+=arr[i];
            }else {
                coun=0;
                max=Math.max(coun,max);
            }
        }
        return max;
    }
}
