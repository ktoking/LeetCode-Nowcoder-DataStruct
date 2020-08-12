package BUFFcode.WrittenTest.ShenCe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        if(str1.equals("")||str2.equals("")){
            System.out.println("false");
            return;
        }
        final boolean b = stringPermutation(str1, str2);
        if(b) System.out.println("true");
        else System.out.println("false");
    }
    public static boolean stringPermutation(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if (String.copyValueOf(a).equals(String.valueOf(b))) {
            return true;
        }
        return false;
    }
}
