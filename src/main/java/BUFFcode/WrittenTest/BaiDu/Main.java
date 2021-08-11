package BUFFcode.WrittenTest.BaiDu;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        Integer arr[]=new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
        }
        StringBuilder sb=new StringBuilder();
        Arrays.stream(arr).sorted(Comparator.reverseOrder()).forEach(e-> sb.append(e));
        BigInteger mod = new BigInteger(sb.toString()).mod(new BigInteger("90"));
        if(mod.compareTo(new BigInteger("0"))==0){
            System.out.println(sb);
        }else {
            System.out.println(-1);
        }


    }
}
