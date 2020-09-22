package LeetCode.swordToOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 */
public class Offer_9_22_50 {
    /**
     * 双hash表
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }


    /**
     * LinkHashMap顺序hash表
     * @param s
     * @return
     */
    public char firstUniqChar1(String s) {
       Map<Character,Boolean> map=new LinkedHashMap<>();
       for (int i = 0; i < s.length(); i++) {
           map.put(s.charAt(i),!map.containsKey(s.charAt(i)));
       }
        for (Map.Entry<Character, Boolean> characterBooleanEntry : map.entrySet()) {
            if(characterBooleanEntry.getValue()){
                return characterBooleanEntry.getKey();
            }
        }
        return ' ';
    }
}
