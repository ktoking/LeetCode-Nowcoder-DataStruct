package src.BUFFcode.WrittenTest.XiaPi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.nextLine();
            String substring = next.substring(1, next.length()-1);
            String[] split = substring.split(",");
            int[] arr=new int[split.length];
            for (int i = 0; i < split.length; i++) {
                arr[i]=Integer.parseInt(split[i].trim());
            }

            int res = 0;
            Map<Integer, Integer> index = new HashMap<>();
            int n = arr.length;
            for(int i = 0; i < n; i++){
                index.put(arr[i], i);
            }

            for(int i = 0; i < n; i += 2){
                int change = arr[i] % 2 == 0 ? index.get(arr[i] + 1) : index.get(arr[i] - 1);
                if(change != i + 1){
                    index.put(arr[i + 1], change);
                    int temp = arr[change];
                    arr[change] = arr[i + 1];
                    arr[i + 1] = temp;
                    res++;
                }
            }
            System.out.println(res);
        }




    }
}
