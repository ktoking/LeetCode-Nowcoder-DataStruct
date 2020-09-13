package BUFFcode.WrittenTest.DuXiaoMan;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    /**
     * 等差公式+大数操作
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BigInteger bigInteger=new BigInteger(m+"").multiply(new BigInteger(n+"")).multiply(new BigInteger("3"));
        BigInteger bigInteger1=new BigInteger("1").add(new BigInteger(n+"").multiply(new BigInteger("3")));
//        long sum=((m+(3*n)*m)*(3*n))/2;
        BigInteger multiply = bigInteger.multiply(bigInteger1);
        System.out.println(multiply.divide(new BigInteger("2")));
    }
}
