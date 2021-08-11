package BUFFcode.WrittenTest;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public void sortLetter(String s){
        Scanner scanner=new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length-1-i; j++) {
                if(chars[j+1]<chars[j]){
                    char temp=chars[j+1];
                    chars[j+1]=chars[j];
                    chars[j]=temp;
                }
            }
        }
        for (char aChar : chars) {
            System.out.printf(aChar+"");
        }
    }

    public static void main(String[] args) {


    }


}
