package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Test_11_22__242 {
    /**
     * 先排序后再比较
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return String.valueOf(chars).equals(String.valueOf(chars1));
    }

    /**
     * 放到map里面记录次数,最后返回map是否为空
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            if(!map.containsKey(t.charAt(i))) return false;
            else if(map.get(t.charAt(i))>1){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }else {
                map.remove(t.charAt(i));
            }
        }
        return map.isEmpty();
    }
}
