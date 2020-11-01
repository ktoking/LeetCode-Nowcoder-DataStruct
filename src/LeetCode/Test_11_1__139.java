package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Test_11_1__139 {

    public static void main(String[] args) {
        List<String> wordDict=new ArrayList<>();
        wordDict.add("dig");
        wordDict.add("and");
        System.out.println(wordBreak("diganddig",wordDict));
    }

    /**
     * 暴力回溯未剪枝,aaaaaaaa过不了
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        return dfs(s,set);
    }
    public static boolean dfs(String s, Set<String> wordDict) {
        if (s.length() == 0) return true;
        for (int i = 0; i < s.length(); i++) {
            if(wordDict.contains(s.substring(0,i+1))){
               if(dfs(s.substring(i+1),wordDict)){
                   return true;
               }
            }
        }
        return false;
    }
}
