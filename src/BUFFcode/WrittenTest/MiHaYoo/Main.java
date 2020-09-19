package BUFFcode.WrittenTest.MiHaYoo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        char[] c=new char[26];
        int count=0;
        for (char i = 'A'; i<='Z'; i++) {
            c[count++]=i;
        }
        char[][] chars=new char[m][n];
        shunshizhen(chars,c);
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.printf(chars[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void shunshizhen(char[][] matrix,char[] rtVal) {
        int t=0,r=matrix[0].length-1,b=matrix.length-1,l=0,index=0;
        while (true){
            for (int i = l; i <=r ; i++) {if(index==26){ index=0;} matrix[t][i]=rtVal[index++];}
            if(++t>b) break;
            for (int i = t; i <=b ; i++) {if(index==26){ index=0;} matrix[i][r]=rtVal[index++];}
            if(--r<l) break;
            for (int i = r; i >=l ; i--) {if(index==26){ index=0;}matrix[b][i]=rtVal[index++];}
            if(--b<t) break;
            for (int i = b; i >=t ; i--) {if(index==26){ index=0;}matrix[i][l]=rtVal[index++];}
            if(r<++l) break;
        }
    }

}
