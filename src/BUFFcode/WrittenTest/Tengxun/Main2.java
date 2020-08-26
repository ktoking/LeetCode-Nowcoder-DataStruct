package BUFFcode.WrittenTest.Tengxun;

import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String next = scanner.next();
        char[] chars = next.toCharArray();
        Arrays.sort(chars);
        String s=new String(chars);
        int k = scanner.nextInt();
        int left=0,right=0;
        int count=0;
        while (left<s.length()&&count<k){
            if(right>s.length()-1){
                left++;
                left=right;
            }else {
                right++;
            }
            count++;
        }
        System.out.println(s.substring(left,right));
    }
}
