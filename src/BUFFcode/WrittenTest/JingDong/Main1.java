package BUFFcode.WrittenTest.JingDong;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int count=0;
        for (int i = N; i <=M ; i++) {
            if(isQHui(i)){ count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isQHui(int num){
        StringBuilder sb=new StringBuilder(String.valueOf(num));
        for (int i = 0; i < sb.length(); i++) {
            Character c=sb.charAt(i);
            if(sb.length()==1||isHui(sb.deleteCharAt(i))){
                if(isSu(sb)){
                    return true;
                }
            }
            sb.insert(i,c);
        }
        return false;
    }
    public static boolean isHui(StringBuilder sb){
        if(sb.length()==0) return true;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)!=sb.charAt(sb.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public static boolean isSu(StringBuilder sb){
        if(sb.length()==0) return true;
        int num = Integer.parseInt(sb.toString());
        if(num>=2&&num<=3) return true;
        if(num<=1) return false;
        for (int i = 2; i < num; i+=1) {
            if(num%i==0) return false;
        }
        return true;
    }
}
