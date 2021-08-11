package BUFFcode.WrittenTest.WeiMeng;

import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {
        String s = reverseWord("There is a dog.");
        System.out.println(s);
    }

    public static String reverseWord (String str) {
        // write code here
        String[] s = str.split(" ");
        StringBuilder sb=new StringBuilder();
        for (String s1 : s) {
            StringBuilder sb1=new StringBuilder(s1);
            sb.append(sb1.reverse()+" ");
        }
        return sb.toString().trim();
    }
}
