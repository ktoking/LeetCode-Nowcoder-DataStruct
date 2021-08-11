package BUFFcode.WrittenTest.YingTaiLai;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        System.out.println(get(s1,s2));
    }

    public static int get(String s1,String s2){
        if(s2==null||s2.length()==0) return 0;
        return   s1.indexOf(s2);
    }
}
