package LeetCode;

import java.util.*;

public class Test_11_1__ss {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str="";
        while (scanner.hasNext()){
            str+=scanner.nextLine();
        }
        String s = str.substring(1, str.length()-1);
        String[] split = s.split(",");
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <split.length ; i++) {
            set.add(Integer.parseInt(split[i]));
        }
        int i=0;
        for ( i = 0; i < split.length; i++) {
            if(!set.contains(i)){
                System.out.println(i);
                break;
            }
        }
        if(i==split.length) System.out.println(i);
    }
}
