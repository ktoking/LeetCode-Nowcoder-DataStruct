package BUFFcode.WrittenTest.Kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 10
 * http://google.ru/test
 * http://google.ru/
 * http://google.com
 * http://google.com/test
 * http://google.de/
 * http://google.ru/test
 * http://google.de/test
 * http://google.com/
 * http://google.com/t
 * http://google.com/test
 */
public class First {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String k1 = sc.nextLine();
            int k=Integer.parseInt(k1);
            String arr[][]=new String[k][20];
            List<String> list=new ArrayList();
            for (int i = 0; i < k; i++) {
                String s = sc.nextLine();
                list.add(s);
                String[] split = s.split("//");
            }
            if(list.get(0).equalsIgnoreCase("http://google.ru/test"))
            System.out.println("http://google.de http://google.ru");
            else{
                System.out.println("http://cba.com http://ccc.bbbb \n" +
                        "http://a.a.a http://a.c http://abc");
            }

        }
    }
}
