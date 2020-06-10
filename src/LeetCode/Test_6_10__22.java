package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test_6_10__22 {

    public static void main(String[] args) {
        System.out.println("暴力解法");
        List<String> list = get(3);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("************************************");
        System.out.println("优化算法");
        List<String> list1 = generateParenthesis(3);
        for (String s : list1) {
            System.out.println(s);
        }
    }

    /**
     * 暴力解法
     * @param n
     * @return
     */
    public static List<String> get(int n){
        List<String> list=new ArrayList<>();
        genAll(new char[n*2],0,list);
        return list;
    }
    public static void genAll(char[] arr,int poi,List<String> res){
        if(arr.length==poi){ //递归结束条件,当数组长度等于给定n的2倍,判断是否符合条件,符合就添加进去
            if(vaild(arr)){
                res.add(new String(arr));
            }
        }else {
            arr[poi]='(';
            genAll(arr,poi+1,res);
            arr[poi]=')';
            genAll(arr,poi+1,res);
        }
    }
    public static boolean vaild(char[] arr){
        int balance=0;
        for (char c : arr) {
            if(c=='(') balance++;
            else balance--;
            if(balance<0) return false;
        }
        return balance==0;
    }




    /**
     * 优化解法
     */
    public static List<String> generateParenthesis(int n){
        List<String> list=new ArrayList<>();
        generate(list,"",0,0,n);
        return list;
    }
    /**
     *
     * @param res 结果集
     * @param ans 字符串添加"("或")"
     * @param count1 "(" 的数量
     * @param count2 ")" 的数量
     * @param n        给定n
     */
    public static void generate(List<String> res,String ans,int count1,int count2,int n){
        if(count1>n||count2>n)return; //递归结束条件 当左括号数量大于n或右括号的数量大于n就返回
        if(count1==n&&count2==n) res.add(ans); //当左括号的数量与与右括号的数量都等于n才加入list
        if(count1>=count2){
            String ans1=new String(ans);
            generate(res,ans1+"(",count1+1,count2,n); //添加( 将左括号数量+1 递归
            generate(res,ans1+")",count1,count2+1,n); //添加) 将右括号数量+1 递归
        }
    }


}


