package BUFFcode.WrittenTest.MeiTuan;

import java.util.*;


public class Main1   {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long arr[]=new long[n];
        Map<Long,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            arr[i]=v+w*2;
            if(map.containsKey(arr[i])){
                List<Integer> list = map.get(arr[i]);
                list.add(i);
                map.put(arr[i],list);
            }else {
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(arr[i],list);
            }
        }
        long[] ints = Arrays.stream(arr).distinct().sorted().toArray();
        for (int i = ints.length-1; i >=0 ; i--) {
            if(m<=0) break;
            else {
                List<Integer> list = map.get(ints[i]);
                Collections.sort(list);
                if(m<=0) break;
                for (Integer integer : list) {
                    if(m<=0) break;
                    System.out.printf("%d ",integer+1);
                    m--;
                }
            }
        }
    }
}
