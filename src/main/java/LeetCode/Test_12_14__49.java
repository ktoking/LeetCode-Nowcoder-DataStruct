package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Test_12_14__49 {

    /**
     * 常规做法,那我每次都排个序加到map里面去,排完序的key不就是一样的吗,那我就找到相同key的list 从map里找到后,add进去再写回去
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] str=strs[i].toCharArray();
            Arrays.sort(str);
            String newStr=String.valueOf(str);
            List<String> orDefault = map.getOrDefault(newStr, new ArrayList<>());
            orDefault.add(strs[i]);
            map.put(newStr,orDefault);
        }
        return new ArrayList<List<String>>(map.values());
    }


    /**
     * groupingby 使用的就是stream流api,狂拽酷霸炫
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> collect = Arrays.stream(strs).collect(Collectors.groupingBy((str) -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }));
        return new ArrayList<>(collect.values());
    }

}
