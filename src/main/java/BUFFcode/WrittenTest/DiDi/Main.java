package BUFFcode.WrittenTest.DiDi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> list=new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num = scanner.nextInt();
        int count=0;
        for (int i = 100; i <= 999; i++) {
            if(ifnum(i,num)) count++;
        }
        if(count==0){
            list.add("0");
        }
        System.out.println(count);
        Collections.sort(list);
        for (String s : list) {
            if(s.equals("0")) System.out.println(s);
            else {
                System.out.println(s.substring(0,3)+" "+s.substring(3,6));
            }
        }
    }

    public static boolean ifnum(int num,int val){
        int c=num%10;
        int b=num/10%10;
        int a=num/100%10;
        if(a==b||a==c||b==c) return false;
        int abc=a*100+b*10+c;
        int acc=a*100+c*10+c;
        if(abc+acc==val){
            list.add(abc+""+acc);
            return true;
        }else return false;
    }
}
