package BUFFcode.WrittenTest.GuangLD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int count=1;
        int[] num=new int[n];
        for (int i = 0; i < n; i++) {
            num[i]=scanner.nextInt();
        }
        int[] arr=new int[n];
        System.arraycopy(num,0,arr,0,n);
        Arrays.sort(arr);
        int m=arr[0];
        int in=1;
        for (int i = 0; i < n; i++) {
            if(num[i]==m){
                for (int j = i+1; j < n; j++) {
                    if(num[j]==arr[in]){
                        count++;in++;
                    }
                }
                break;
            }
        }
        System.out.println(count);
    }

}
