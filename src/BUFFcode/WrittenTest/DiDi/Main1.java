package BUFFcode.WrittenTest.DiDi;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num = scanner.nextInt();
        int all=num*num;
        long[] arr=new long[all];
        getFei(arr);
        int top=num,left=num,right=num,bott=num,index=arr.length-1;
        String twoArr[][] =new String[num][num];
        get(arr,num,twoArr); //先整到二维数组中遍历

        for (int i = 0; i < twoArr.length; i++) {
            for (int j = 0; j < twoArr[0].length; j++) {
                System.out.printf(twoArr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void getFei(long[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(i==0) arr[i]=1;
            else if(i==1) arr[i]=1;
            else arr[i]=arr[i-1]+arr[i-2];
        }
    }

    public static void get(long[] arr,int num,String[][]towNum){
        int top=0,right=num-1,bottom=num-1,left=0,index=arr.length-1;
        while (true){
            for (int i = left; i <=right ; i++)
                towNum[top][i]=arr[index--]+"";
            if(++top>bottom) break;
            for (int i = top; i <=bottom ; i++)
                towNum[i][right]=arr[index--]+"";
            if(--right<left) break;
            for (int i = right; i >=left ; i--)
                towNum[bottom][i]=arr[index--]+"";
            if(--bottom<top) break;
            for (int i = bottom; i >=top ; i--)
                towNum[i][left]=arr[index--]+"";
            if(right<++left) break;
        }
    }
}
