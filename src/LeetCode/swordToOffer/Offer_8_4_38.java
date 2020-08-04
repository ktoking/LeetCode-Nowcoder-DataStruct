package LeetCode.swordToOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 */
public class Offer_8_4_38 {
    List<String> list=new ArrayList<>();

    public static void main(String[] args) {
        Offer_8_4_38 o=new Offer_8_4_38();
        String[] abbs = o.permutation("abb");
        for (String abb : abbs) {
            System.out.println(abb);
        }
    }

    /**
     * 全排列，考虑不重复
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        quan(0,s.toCharArray());
       return list.toArray(new String[list.size()]);
    }
    public void quan(int start,char[] s){
        if(start==s.length){
            list.add(String.valueOf(s));
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i <s.length; i++) {
            if(set.contains(s[i])) continue; // 重复，因此剪枝
            set.add(s[i]);
            swap(s,i,start);
            quan(start+1,s);
            swap(s,i,start);
        }
    }
    public void swap(char[] s,int i,int j){
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
}
