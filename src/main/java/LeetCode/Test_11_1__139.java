package LeetCode;

import java.util.*;

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

    /**
     * 动态规划, diganddig
     *           j  i
     *           我们判断dp[i]表示是否能划分i之前的单词，j-i的后缀是否在字符串数组中
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0;j<i;j++) {
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 增加一个booleanboolean数组表示当前位置之后的字符串是否遍历过了，如果遍历过了并且没有提前递归的返回truetrue说明，这个位置后面的匹配是不会成功的，因此直接返回falsefalse。
     *
     * 作者：outvoker-c
     * 链接：https://leetcode-cn.com/problems/word-break/solution/javahui-su-dao-ji-yi-hua-hui-su-zai-dao-dong-tai-g/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    boolean[] mem;
    public boolean backtrack(String s, int start, Set<String> set) {
        if (s.length() == 0) return true;
        if (mem[start]) return false;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(0, i + 1))){
                if (backtrack(s.substring(i + 1), start + i + 1, set)) return true;
            }
        }
        mem[start] = true;
        return false;
    }
    public boolean wordBreak1(String s, List<String> wordDict) {
        this.mem = new boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        return backtrack(s, 0, set);
    }
}
