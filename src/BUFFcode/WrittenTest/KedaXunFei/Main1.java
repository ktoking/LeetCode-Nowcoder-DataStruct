package BUFFcode.WrittenTest.KedaXunFei;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr=new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i]=scanner.nextInt();
        }
        boolean flag=false;
        for (int i = arr[1]; i <=arr[3] ; i++) {
            for (int j = arr[0]; j <= arr[2]; j++) {
                if((i==arr[4]&&j==arr[5])|| (i==arr[6]&&j==arr[7])||(i==arr[4]&&j==arr[7])||(i==arr[6]&&j==arr[5])){
                    flag=true;break;
                }
            }
        }

        if(flag){
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }
}
