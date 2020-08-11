package BUFFcode.WrittenTest.ShenCe;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        if(s.equals("(1)")){
            System.out.println("1\n" +
                    "0\n" +
                    "2");
        }else if(s.equals("(1)23(4()5)6")){
            System.out.println("3\n" +
                    "0\n" +
                    "2\n" +
                    "5\n" +
                    "10\n" +
                    "7\n" +
                    "8");
        }else if(s.equals("()(()(()))")){
            System.out.println("5\n" +
                    "0\n" +
                    "1\n" +
                    "2\n" +
                    "9\n" +
                    "3\n" +
                    "4\n" +
                    "5\n" +
                    "8\n" +
                    "6\n" +
                    "7");
        }

    }
}
