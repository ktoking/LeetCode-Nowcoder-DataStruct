package src.BUFFcode.WrittenTest.XiaPi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String next = scanner.next();
        String substring = next.substring(1, next.length()-1);
        String[] split = substring.split(",");
        int[] arr=new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i]=Integer.parseInt(split[i]);
        }

        int res = 0;
        Map<Integer, Integer> index = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            index.put(arr[i], i);
        }

        for(int i = 0; i < n; i += 2){
            // 本题特性：如果是i对应偶数说明它对象是row[i]+1，奇数是row[i]-1
            int exchange = arr[i] % 2 == 0 ?
                    index.get(arr[i] + 1) : index.get(arr[i] - 1);
            if(exchange != i + 1){
                index.put(arr[i + 1], exchange); // 先更新Hash里面的索引，只更新没有确定位置的那个就好
                int temp = arr[exchange];
                arr[exchange] = arr[i + 1];
                arr[i + 1] = temp;
                res++;
            }
        }
        System.out.println(res);
    }
}
