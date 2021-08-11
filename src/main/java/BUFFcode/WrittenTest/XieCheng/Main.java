package BUFFcode.WrittenTest.XieCheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

//    public int waysToChange(int n) {
//        int[] coins = new int[]{a,b,k};
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        for (int coin : coins) {
//            for (int i = 1; i <= n; i++) {
//                if (i - coin >= 0) {
//                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
//                }
//            }
//        }
//        return dp[n];
//    }

    static int[] divingBoard(int a, int b, int k) {
        if(k==0){
            return new int[0];
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            list.add(a*i+b*(k-i));
        }
        list.stream().sorted().distinct().collect(Collectors.toList());
        int[] arr=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[list.size()-i-1]=list.get(i);
        }
        return arr;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = divingBoard(_a, _b, _k);
        String value = "[]";
        if (res != null && res.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                if (i == 0) {
                    stringBuilder.append("[");
                }
                stringBuilder.append(res[i]);
                if (i == res.length - 1) {
                    stringBuilder.append("]");
                } else {
                    stringBuilder.append(",");
                }
            }
            value = stringBuilder.toString();
        }
        System.out.println(value);
    }




}
