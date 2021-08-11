package BUFFcode.WrittenTest.JingDong;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nextInt = scanner.nextInt();
        if(nextInt<=0) System.out.println(0.0000);
        double sum=0.0;
        for (int i = 5; i <= nextInt*10; i+=5) {
            if(i%2==0){
                sum+=-(1.0/i);
            }else {
                sum+=(1.0/i);
            }
        }
        String s = new Double(sum).toString();
        if(s.length()>6){
            System.out.println(s.substring(0,6));
        }else {
            for (int i = s.length(); i < 6 ; i++) {
                s=s+"0";
            }
            System.out.println(s);
        }
    }
}
