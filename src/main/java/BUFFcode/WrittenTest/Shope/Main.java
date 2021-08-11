package BUFFcode.WrittenTest.Shope;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String target = scanner.nextLine();
        boolean isfirst=false;
        boolean toUp=false;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            if(!isfirst){
                if(Character.isDigit(target.charAt(i))){
                    sb.append(target.charAt(i));
                    isfirst=true;
                }
                else if(Character.isLetter(target.charAt(i))){
                    sb.append(Character.toLowerCase(target.charAt(i)));
                    isfirst=true;
                }
            }else {
                if(toUp){
                    if(Character.isDigit(target.charAt(i))){
                        sb.append(target.charAt(i));
                        toUp=false;
                    }else if(Character.isLetter(target.charAt(i))){
                        sb.append(Character.toUpperCase(target.charAt(i)));
                        toUp=false;
                    }
                }else {
                    if(Character.isDigit(target.charAt(i))){
                        sb.append(target.charAt(i));
                    }else if(Character.isLetter(target.charAt(i))){
                        sb.append(Character.toLowerCase(target.charAt(i)));
                    }
                    else {
                            toUp=true;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
