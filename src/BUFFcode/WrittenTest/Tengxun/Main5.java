package BUFFcode.WrittenTest.Tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String next = scanner.next();
        int row = scanner.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            list.add(get(next.substring(l-1,r)));
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    public static int get(String str){
        int count=0;
        for (int i = str.length()-1; i >=0; i--) {
           if(ifhui(str.substring(0,i)))  return 1;
           else count++;
        }
        return str.length()-1;
    }
    public static boolean ifhui(String s1){
        int left=0,right=s1.length()-1;
        if (s1.length()==1) return true;
        while (left<right){
            if(s1.charAt(left)==s1.charAt(right)){
                left++;right--;
            }else return false;
        }
        return true;
    }
}
