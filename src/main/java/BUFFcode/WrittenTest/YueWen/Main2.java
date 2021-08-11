package BUFFcode.WrittenTest.YueWen;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num = scanner.nextInt();
        int count=0;
        while (num!=0){
            int temp=num;
            int r=temp&1;
            if(r==1) count++;
            num=num>>1;
        }
        System.out.println(count);
    }

    public int countBit (int n) {
        int count=0;
        while (n!=0){
            int temp=n;
            int r=temp&1;
            if(r==1) count++;
            n=n>>1;
        }
        return count;
    }
}
