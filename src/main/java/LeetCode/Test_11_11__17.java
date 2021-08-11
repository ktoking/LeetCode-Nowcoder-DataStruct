package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Test_11_11__17 {

    /**
     * 回溯大法好!直接用string的回溯
     */
    static String[] strmap={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> list=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0||digits==null) return list;
        huisu("",0,digits);
        return list;
    }
    public void huisu(String s,int index,String digits){
        if(index==digits.length()) {
            list.add(s);
            return;
        }
        String ss=strmap[digits.charAt(index)-'0'];
        for (int i = 0; i < ss.length(); i++) {
            huisu(s+ss.charAt(i),index+1,digits);
        }
    }
}
