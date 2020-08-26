package BUFFcode.WrittenTest.Tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int i1 = scanner.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < i1; i++) {
            int num = scanner.nextInt();
            list.add(getMax(num));
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    public static int getMax(int num){
        int max=0;
        for (int i = 0; i <= num/2; i++) {
            max=Integer.max(max,getnum(i)+getnum(num-i));
        }
        return max;
    }
    public static int getnum(int num){
        int sum=0;
        while (num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
