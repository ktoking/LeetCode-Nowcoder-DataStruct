package BUFFcode.WrittenTest.XiaoMi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            boolean low=false;
            boolean hig=false;
            boolean dig=false;
            boolean fuhao=false;
            if(next.length()>=8&&next.length()<=120){
                for (int i = 0; i < next.length(); i++) {
                    if(Character.isUpperCase(next.charAt(i))){
                        hig=true;
                    }else if(Character.isLowerCase(next.charAt(i))){
                        low=true;
                    }else if(Character.isDigit(next.charAt(i))){
                        dig=true;
                    }else {
                        fuhao=true;
                    }
                }
                if(low&&hig&&dig&&fuhao){
                    System.out.println(0);
                }else {
                    System.out.println(2);
                }
            }else {
                System.out.println(1);
            }
        }
    }
}
