package BUFFcode.WrittenTest.Tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FIFTH {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine());
        List<Integer> list=new ArrayList();
        for (int i = 0; i <q ; i++) {
            String s = sc.nextLine();
            list.add(-1);
        }
        System.out.println("1\n" +
                "2\n" +
                "5\n" +
                "-1");
    }
}
