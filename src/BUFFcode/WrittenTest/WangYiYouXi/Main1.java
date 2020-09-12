package BUFFcode.WrittenTest.WangYiYouXi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

    Map<Integer, Character> map = new HashMap<>();

    public String compress(String raw_str) {
        //a-Z 4-55
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i - 'a' + 4, i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(i - 'A' + 30, i);
        }
        return get(raw_str + " ");
    }

    public String get(String str) {
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                right++;
            } else {
                if (right - left + 1 >= 4) {
                    sb.append(transfer(str, left, right));
                } else {
                    sb.append(str.substring(left, right + 1));
                }
                left = i + 1;
                right = i + 1;
            }
        }
        return sb.toString();
    }

    public String transfer(String str, int left, int right) {
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            if (left+55<=right) {
                sb.append("0" + map.get(55) + str.charAt(left));
                left += 55;
            } else {
                if(right - left + 1>=4){
                    sb.append("0" + map.get(right - left + 1) + str.charAt(left));
                }else {
                    sb.append(str.substring(left,right+1));
                }
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main1 main1 = new Main1();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 55; i++) {
            sb.append("a");
        }
        System.out.println(main1.compress(sb.toString()+"a"));
    }
}