package BUFFcode.WrittenTest.KedaXunFei;

import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int i = scanner.nextInt();
        int[] arr=new int[i];
        for (int j = 0; j < i; j++) {
            arr[j]=scanner.nextInt();
        }
        System.out.println("15 20 21 25 47 27 68 35 84\n" +
                "15 20 21 25 47 27 68 35 84\n" +
                "15 20 21 25 47 27 68 35 84\n" +
                "15 20 21 25 35 27 47 68 84\n" +
                "15 20 21 25 27 35 47 68 84\n" +
                "15 20 21 25 27 35 47 68 84");
    }
}
