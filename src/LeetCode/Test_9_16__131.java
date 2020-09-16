package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Test_9_16__131 {

    /**
     * 131. 分割回文串,经典回溯模板
     *        a          a              b
     *      /           |               \
     * 截取a ->a      截取aa ->b        截取aab 不是回文剪枝
     * /                |
     * 截取a->b       截取b->空字符串
     * /
     * 截取b->空字符串
     */

    List<List<String>> lists=new ArrayList<>();
    public List<List<String>> partition(String s) {
        huisu(new ArrayList<>(),0,s);
        return lists;
    }
    public void huisu(List<String> list,int index,String s){
        if(index==s.length()){
            lists.add(new ArrayList<>(list));return;
        }
        for (int i = index; i < s.length(); i++) {
            String str=s.substring(index,i+1);
            if(!ifhui(str)) continue;
            list.add(str);
            huisu(list,i+1,s);
            list.remove(list.size()-1);
        }
    }
    public  boolean ifhui(String str){
        boolean flag=true;
        for (int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
