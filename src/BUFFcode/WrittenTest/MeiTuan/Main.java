package BUFFcode.WrittenTest.MeiTuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>list=new ArrayList<>();
        int row = scanner.nextInt();
        for (int i = 0; i < row; i++) {
            if(ifStr(scanner.next())){
                list.add("Accept");
            }else {
                list.add("Wrong");
            }
        }
        for (String s : list) {
            System.out.println(s);

        }
    }

    public static boolean ifStr(String s){
        int letter=0;
        int numcount=0;
        if(Character.isLetter(s.charAt(0))){
            for (int i = 1; i < s.length(); i++) {
                if(Character.isLetterOrDigit(s.charAt(i))){
                    if(Character.isLetter(s.charAt(i))){
                        letter++;
                    }else {
                        numcount++;
                    }
                }else {
                    return false;
                }
            }
        }else {
            return false;
        }
        if(letter>0&&numcount>0) return true;
        else return false;

    }
}
