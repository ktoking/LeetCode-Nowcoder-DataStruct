package BUFFcode.NewCodeTest8;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/cc727473d1e248ccb674eb31bd8683dc
 * 来源：牛客网
 *
 * 找出n个数里最小的k个
 *
 * 输入描述:
 * 每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n
 * 不超过100。
 *
 *
 * 输出描述:
 * 输出n个整数里最小的k个数。升序输出
 * 示例1
 * 输入
 * 3 9 6 8 -10 7 -11 19 30 12 23 5
 * 输出
 * -11 -10 3 6 7
 *
 * 快速排序输出
 */
public class N_Knew {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int[] arr=new int[s1.length];
            for (int i = 0; i < s1.length; i++) {
                arr[i]=Integer.parseInt(s1[i]);
            }
            sort(arr,0,arr.length-1);
            for (int i = 0; i < arr.length; i++) {
                System.out.printf(i==arr.length-1?String.valueOf(arr[i]):arr[i]+" ");
            }
        }


    }

    public static void sort(int arr[],int low,int high){
        if(low<high){
            int index=getIndex(arr,low,high);

            sort(arr,0,index-1);
            sort(arr,index+1,high);
        }
    }
    public static int getIndex(int[] arr,int low,int high){
        int temp=arr[low];
        while(low<high){
            while(low<high&&arr[high]>=temp) high--;   //这边等于也不做任何操作
            arr[low]=arr[high];
            while(low<high&&arr[low]<=temp) low++;
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }


}
