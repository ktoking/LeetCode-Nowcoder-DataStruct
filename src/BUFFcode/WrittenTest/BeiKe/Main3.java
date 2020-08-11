package BUFFcode.WrittenTest.BeiKe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int arr[]=new int[nextInt];
        for (int i = 0; i <nextInt ; i++) {
            arr[i]=scanner.nextInt();
        }

        System.out.println(new Random().nextInt(10));
    }
}
