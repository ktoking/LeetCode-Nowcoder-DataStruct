package BUFFcode.WrittenTest.WangYi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int add=n-m;
        int arr[]=new int[m];
        int min=Integer.MAX_VALUE;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=scanner.nextInt();
            if(arr[i]<min) min=arr[i];
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        int cur=0;
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(i<min&&add-->0){
                sb.append(i+" ");
            }else  {

            }
        }
//        StringBuilder sb=new StringBuilder();
//        while (true){
//            int i=0;
//            if(min==arr[i]){
//                sb.append(arr[i]+" ");
//                min+=1;
//                i++;
//            }else {
//                if(map.containsKey(min)){
//
//                }
//            }
//        }

    }
}
