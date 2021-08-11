package BUFFcode.WrittenTest.GuangLD;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Long  nextInt = scanner.nextLong();
        List<Long> list=new ArrayList<>();
        Map<Long,Integer> map=new HashMap<>();
        for (int i = 0; i < nextInt; i++) {
            Long num = scanner.nextLong();
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
                list.add(num);
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        int flag=0;
        BigDecimal a=new BigDecimal(0);
        for (Long integer : list) {
            if(map.get(integer)>=2){
               if(flag==0){
                   a=new BigDecimal(integer);
                   flag++;
               }else if(flag==1){
                   a=a.multiply(BigDecimal.valueOf(integer));
                   System.out.println(a);
                   break;
               }
            }else if(map.get(integer)==4){
                System.out.println(integer*2);
                break;
            }
        }
        if(a.compareTo(new BigDecimal(1))<0){
            System.out.println(-1);
        }
    }
}
