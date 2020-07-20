package BUFFcode.WrittenTest.Alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondDemo {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList();
        int row=scanner.nextInt();
        for (int i = 0; i < row; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int count=0;
            for (int j = n; j <=k ; j++) {
                 if(isNum(j)) {
                     count++;
                 }
            }
            list.add(count);
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    public static boolean isNum(int num){
        StringBuilder sb=new StringBuilder(num+"");
        int count=sb.length();
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count - i - 1; j++) {
                    int k=Math.abs(Integer.valueOf(sb.charAt(j))-Integer.valueOf(sb.charAt(j+1)));
                    sb.replace(j,j+1,String.valueOf(k));
                }
            }char c = sb.charAt(0);

        if(c-'7'==0){
            return true;
        }else {
            return false;
        }
    }
}
