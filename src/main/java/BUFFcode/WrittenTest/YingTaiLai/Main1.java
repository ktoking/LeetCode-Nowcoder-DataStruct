package BUFFcode.WrittenTest.YingTaiLai;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split(",");
        int[] arr=new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(split[i]);
        }
        int left=0,max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int maxceng=Integer.MIN_VALUE,count=0;
            for (int j = i; j < arr.length; j++) {
                count+=arr[j];
                maxceng=Math.max(count,maxceng);
            }
            max=Math.max(maxceng,max);
        }
        System.out.println(max);
    }
}
