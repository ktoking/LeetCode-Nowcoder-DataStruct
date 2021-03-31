//package BUFFcode.WrittenTest.MeiTuan;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main9 {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n = scanner.nextInt();
//        int arr[]=new int[n];//货物重量
//        int opt[]=new int[n];//去除顺序
//        for (int i = 0; i <n ; i++) {
//            arr[i]=scanner.nextInt();
//        }
//        for (int i = 0; i <n ; i++) {
//            opt[i]=scanner.nextInt();
//        }
//        int []sum=new int[n+1 ];
//        sum[0]=0;
//        for (int i=1;i<n+1;i++){
//            sum[i]=sum[i-1]+wight[i-1];
//        }
//        int l=0;
//        int r=n;
//        for (int i=0;i<n;i++){
//            int mid=nums[i];
//            System.out.println(Math.max(sum[mid-1]-sum[l],sum[r]-sum[mid]));
//            for (int j=mid;j<n+1;j++){
//                sum[j]=sum[j]-wight[mid-1];
//            }
//        }
//    }
//
//}
