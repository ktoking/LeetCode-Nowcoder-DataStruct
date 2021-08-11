package BUFFcode.WrittenTest.PuTaoCheng;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int arr[]={-5,-20,10};
        String[] str={"aaaa","bbbbbbbb","c"};
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
        }
        int count=0;
        for (int i = 0; i < str.length; i++) {
            count+=str[i].length();
        }
        int fucount=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0){
                fucount=Math.max(fucount,-1*arr[i]);
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(max-arr[j]-i<=0){
                    System.out.printf("*");
                    for (int k = 1; k < str[j].length(); k++) {
                        System.out.printf(" ");
                    }
                }else {
                    for (int k = 1; k < str[j].length(); k++) {
                        System.out.printf(" ");
                    }
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < count; i++) {
            System.out.printf("-");
        }
        System.out.println();
        for (int i = 0; i < fucount; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i<(-1*arr[j])&&arr[j]<0){
                    System.out.printf("*");
                    for (int k = 1; k < str[j].length(); k++) {
                        System.out.printf(" ");
                    }
                }else {
                    for (int k = 1; k < str[j].length(); k++) {
                        System.out.printf(" ");
                    }
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < str.length; i++) {
            System.out.printf(str[i]);
        }
    }
}
