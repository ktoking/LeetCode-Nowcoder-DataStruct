package BUFFcode.WrittenTest.BeiKe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nextInt = scanner.nextInt();
        String next = scanner.next();
        final char[] chars = next.toCharArray();
        int l=0,r=chars.length-1;
        int count=0;
        while (l<r){
            if(chars[l]==chars[r]){
                l++;r--;
            }else {
                count++;
                l++;r--;
            }
        }
        System.out.println(count);
    }
}
