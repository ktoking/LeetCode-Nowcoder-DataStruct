package BUFFcode.WrittenTest.KedaXunFei;

import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder sb=new StringBuilder();
        boolean flag=false;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
