package BUFFcode.WrittenTest.QuNaER;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        if(n<m/2){
            n=m-n;
        }
        BigInteger bigInteger=new BigInteger("1");
        for (int i = n+1; i <=m ; i++) {
            bigInteger=bigInteger.multiply(new BigInteger(i+""));
        }
        System.out.println(bigInteger.divide(get(m-n)));
    }
    public static BigInteger get(int num){
        BigInteger n=new BigInteger("1");
        for (int i = 2; i <=num; i++) {
            n=n.multiply(new BigInteger(i+""));
        }
        return n;
    }
}
