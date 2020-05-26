package BUFFcode.WrittenTest.Alibaba;

import java.util.Scanner;

public class FirstDemo {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int n=Integer.parseInt(s1[0]);
            int m=Integer.parseInt(s1[1]);
            int count=1;
            System.out.println((int)((Math.pow(m,n-1))%(Math.pow(10,9)+7)));
        }
    }
}
