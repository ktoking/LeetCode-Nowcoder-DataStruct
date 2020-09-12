package BUFFcode.WrittenTest.ZuiYou;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String next = scanner.next();
        BigInteger sum=new BigInteger("0");
        int ii=0;
        boolean illeagle=true;
        if(next.charAt(0)=='-'){
            for (int i = next.length()-1; i >=1 ; i--) {
                BigInteger jin=new BigInteger("36");
                jin=jin.pow(ii);
                if(Character.isDigit(next.charAt(i))){
                    BigInteger multiply = new BigInteger(next.charAt(i) + "").multiply(jin);
                    sum=sum.add(multiply);
                }else if(Character.isLetter(next.charAt(i))) {
                    BigInteger multiply = new BigInteger(next.charAt(i)-'a'+10+"").multiply(jin);
                    sum=sum.add(multiply);
                }else {
                    illeagle=false;
                    break;
                }
                ii++;
            }
            if(illeagle) {
                if(sum.compareTo(new BigInteger("-9223372036854775807"))<0){
                    System.out.println("-9223372036854775807");
                }else{
                    System.out.println("-"+sum);
                }
            }
            else System.out.println(0);
        }else if(Character.isLetterOrDigit(next.charAt(0))){
            for (int i = next.length()-1; i >=0 ; i--) {
                BigInteger jin=new BigInteger("36");
                jin=jin.pow(ii);
                if(Character.isDigit(next.charAt(i))){
                    BigInteger multiply = new BigInteger(next.charAt(i) + "").multiply(jin);
                    sum=sum.add(multiply);
                }else if(Character.isLetter(next.charAt(i))) {
                    BigInteger multiply = new BigInteger(next.charAt(i)-'a'+10+"").multiply(jin);
                    sum=sum.add(multiply);
                }else {
                    illeagle=true;
                    break;
                }
                ii++;
            }
            if(illeagle) {
                if(sum.compareTo(new BigInteger("9223372036854775807"))>0){
                    System.out.println("9223372036854775807");
                }else {
                    System.out.println(sum);
                }
            }
            else System.out.println(0);
        }else {
            System.out.println(0);
        }
    }
}
