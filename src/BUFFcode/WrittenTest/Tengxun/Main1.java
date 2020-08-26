package BUFFcode.WrittenTest.Tengxun;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long num = scanner.nextLong();
        long k = scanner.nextInt();
        for (long i = 0; i < num; i++) {
            String ii=  scanner.next();
            if(i!=k-1){
                System.out.printf(ii+" ");
            }
        }
    }
}
