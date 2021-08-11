package BUFFcode.WrittenTest.BianLiFeng;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nextInt = scanner.nextInt();
        String[][] strtu=new String[nextInt][2];
        for (int i = 0; i < nextInt; i++) {
            String next = scanner.next();
            String[] split = next.split("->");
            strtu[i][0]=split[0];
            strtu[i][1]=split[1];
        }
       if(get(strtu)){
           System.out.println("Y");
       }else {
           System.out.println("N");
       }
    }

    public static boolean get(String[][] strtu){
        for (int i = 0; i < strtu.length - 1; i++) {
            for (int j = i; j < strtu.length - 1; j++) {
                if(strtu[j][0]==strtu[j+1][1]&&strtu[j][1]==strtu[j+1][0]){
                    return true;
                }else if(strtu[j][1]==strtu[j+1][0]){
                    strtu[j+1][0]=strtu[j][0];
                }
            }
        }
        return false;
    }

//    public String removeOneConnection(int[][] edges){
//
//    }


}
