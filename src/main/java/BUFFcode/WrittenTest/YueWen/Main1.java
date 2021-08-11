package BUFFcode.WrittenTest.YueWen;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long  nextInt = scanner.nextLong();
        if(ifzhi(nextInt)){
            System.out.println("true");
        }else {
            System.out.println("fasle");
        }
    }
    public static boolean ifzhi(long num){
        if(num==2) return true;
        if(num%2==0) return false;
        for (long i = 3; i <= Math.sqrt(num); i+=2) {
            if(num%i==0) return false;
        }
        return true;
    }
    public static boolean ifzhi1(long num){
        if(num==2) return true;
        if(num%6!=1&&num%6!=5){
            return false;
        }
        for (long i = 5; i <= Math.sqrt(num); i+=6) {
            if(num%i==0||num%(i+2)==0) return false;
        }
        return true;
    }
}
