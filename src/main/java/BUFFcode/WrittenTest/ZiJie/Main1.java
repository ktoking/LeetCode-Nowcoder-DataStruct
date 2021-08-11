package BUFFcode.WrittenTest.ZiJie;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-->0){
            String[] s = scanner.nextLine().split(" ");
            if(s[2].equals("+")){
                BigInteger a=new BigInteger(s[0]).add(new BigInteger(s[1]));
                a=a.mod(new BigInteger("1000000007"));
                System.out.println(a);
            }else if(s[2].equals("-")){
                BigInteger a=new BigInteger(s[0]).subtract(new BigInteger(s[1]));
                a=a.remainder(new BigInteger("1000000007"));
                System.out.println(a);
            }else if(s[2].equals("*")){
                BigInteger a=new BigInteger(s[0]).multiply(new BigInteger(s[1]));
                a=a.mod(new BigInteger("1000000007"));
                System.out.println(a);
            }else {
                BigInteger s1=BigInteger.ZERO;
                BigInteger a=new BigInteger(s[0]);
                BigInteger b=new BigInteger(s[1]);
                BigInteger t=a.modPow(b,new BigInteger("1000000007"));//t=a^b%p
                s1=s1.add(t).mod(new BigInteger("1000000007"));//s=(s+t)%p
                System.out.println(s1);
            }
        }
    }
}
