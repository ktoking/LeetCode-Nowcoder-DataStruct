package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.09. 括号
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 同力扣22
 */
public class Test_12_14__0809 {

    /**
     * 隐性回溯法
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String>list=new ArrayList<>();
        generate(list,"",0,0,n);
        return list;
    }
    public static void generate(List<String> res,String ans,int count1,int count2,int n){
        if(count1>n||count2>n) return;
        if(count1==n&&count2==n) res.add(ans);
        if(count1>=count2){
            String ans1=new String(ans);
            generate(res,ans1+"(",count1+1,count2,n);
            generate(res,ans1+")",count1,count2+1,n);
        }
    }
}
