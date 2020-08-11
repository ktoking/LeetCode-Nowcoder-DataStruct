package BUFFcode.WrittenTest.WangYi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int row = scanner.nextInt();
        int[] arr=new int[row];
        long count=0;
        for (int i = 0; i < row; i++) {
            arr[i]=scanner.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            count+=getCount(arr[i]);
        }
        System.out.println(count);
    }

    public static int getCount(int num){
        if(num<=1) return 0;
        return num/2;
    }

    public static boolean isSu(int num){
        if(num<=1) return false;
        for (int i = 2; i < num; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}
