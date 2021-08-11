package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 分解因式,猫眼一面手撕代码
 *
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nextInt = scanner.nextInt();
        List list=new ArrayList();
        for (int i = 2; i <= nextInt ; i++) {
            if(nextInt%i==0){
                list.add(i);
                nextInt/=i;
                i = 1;
            }
        }
        System.out.println(list);
    }
}
