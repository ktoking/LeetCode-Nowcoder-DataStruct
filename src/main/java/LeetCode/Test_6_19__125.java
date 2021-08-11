package LeetCode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_6_19__125 {

    public static void main(String[] args) {
        System.out.println(judge1("A man, a plan, a canal: Panama"));
    }


    /**
     *  判断回文串(只判断字母或数字)
     *  1. 用到了Character.isLetterOrDigit()方法,判断当前字符是否为字母或者数字
     *  2. 利用StringBuilder接收
     *  3. 利用StringBuilder的反转字符串来判断是否一致(StringBuilder反转需要重新定义新对象,不能直接 sb.equals(sb.reverse()) 会一直返回true)
     * @param s
     * @return
     */
    public static boolean judge(String s) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        StringBuilder sb1=new StringBuilder(sb).reverse();
        return sb.toString().equals(sb1.toString());
    }

    /**
     * 双指针判断(更快一点)
     * 1. 定义头尾指针
     * 2. Character.isLetterOrDigit也得利用这个方法去判断头尾指针是否为字母或数字,并且判断相同,如果不同直接返回false
     * 3. 如果不是字母或者数字,那么就让头尾指针向右或向左走一步,结束条件左指针>=右指针
     * @param s
     * @return
     */
    public static boolean judge1(String s){
        int left=0,right=s.length()-1;
        while (left<right){
            if(Character.isLetterOrDigit(s.charAt(left))&&Character.isLetterOrDigit(s.charAt(right))){
                if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;right--;
            }else if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else {
                right--;
            }
        }
        return true;
    }

}
