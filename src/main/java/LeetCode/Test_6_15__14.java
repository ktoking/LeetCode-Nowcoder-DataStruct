package LeetCode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_6_15__14 {

    /**
     * 选择第一次的值为比较对象,每一次进行更新
     *   res=flowey;
     *  1. flowey
     *  2. flowrs
     *  3. fl
     *
     *  1->2比较后, res=flow
     *
     *  2->3比较后. res=fl
     *
     *  返回fl;
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) //如果为空,返回""
            return "";
        String res=strs[0];
        for (int i = 1; i < strs.length; i++) {  //从数组中第二个字符串开始与第一个字符串比较,因为前缀肯定<=任一字符串,所以选取为循环终止条件
            int j=0;
            for ( ; j < res.length()&&j<strs[i].length(); j++) { //在这一步循环中,找到不相同的那一位j
                if(strs[i].charAt(j)!=res.charAt(j)){
                    break;
                }
            }
            res=res.substring(0,j); //进行分割字符串,直到相同的那一位为止
            if (res.equals("")) return res; //进行判断如果没有一位是相同的,那之后也没必要进行比较,直接返回
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strings={"aa","a"};
        System.out.println(longestCommonPrefix1(strings));
    }

    /**
     * 纵相对比,将第一个字符串每一个字母与后面进行比较
     *
     * 1. floww
     * 2. floe
     * 3. fl
     *
     * 第一次比所有字符串的第一个字母 f 第二次第二个 l 第三次发现i==字符串长度了,直接返回 最终返回fl
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length(); //第一个字符串的长度
        int count = strs.length;  //数组总长度
        for (int i = 0; i < length; i++) { //i代表数组第i个字母
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) { //循环数组对象对比
                if (i == strs[j].length() || strs[j].charAt(i) != c) { //如果比较的字母不一样或者比较的字母的长度与字符串长度相同,那就返回到这的字符串
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
