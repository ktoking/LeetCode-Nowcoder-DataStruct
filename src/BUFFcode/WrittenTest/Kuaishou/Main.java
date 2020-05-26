package BUFFcode.WrittenTest.Kuaishou;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){

            int count=0;
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int x=Integer.parseInt(s1[0]);
            int y=Integer.parseInt(s1[1]);
            int arr[][]=new int[x+1][y+1];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    arr[i][j]=sc.nextInt();
                }
            }

            for (int i = 1; i < x-1; i++) {
                for (int j = 1; j < y-1; j++) {
                    if(arr[i-1][j]==0&&arr[i][j-1]==0&&arr[i][j+1]==0&&arr[i+1][j]==0) count++;
                }
            }

            System.out.println(count);
        }
    }
}
