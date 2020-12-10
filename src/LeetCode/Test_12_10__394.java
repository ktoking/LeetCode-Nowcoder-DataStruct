package LeetCode;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class Test_12_10__394 {
    /**
     * 解法一：辅助栈法
     * 本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串，这与栈的先入后出特性对应。
     *
     * 算法流程：
     *
     * 构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
     * 当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
     * 当 c 为字母时，在 res 尾部添加 c；
     * 当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 00：
     * 记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作；
     * 记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
     * 进入到新 [ 后，res 和 multi 重新记录。
     * 当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res，其中:
     * last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
     * cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
     * 返回字符串 res。
     * 复杂度分析：
     *
     * 时间复杂度 O(N)O(N)，一次遍历 s；
     * 空间复杂度 O(N)O(N)，辅助栈在极端情况下需要线性空间，例如 2[2[2[a]]]。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder sb=new StringBuilder();
        int muli=0;
        Stack<Integer> mul=new Stack<>();
        Stack<String> str=new Stack<>();
        for(Character c:s.toCharArray()){
           if(c>='0'&&c<='9') muli=muli*10+Integer.parseInt(c+"");
           else if(c=='['){
               mul.push(muli);
               str.push(sb.toString());
               muli=0;
               sb=new StringBuilder();
           }else if(c==']'){
               StringBuilder temp=new StringBuilder();
               int time=mul.pop();
               for (int i = 0; i < time; i++) {
                   temp.append(sb);
               }
               sb=new StringBuilder(str.pop()+temp);  //重置新的字符串
           }else {
            sb.append(c);
           }
        }
        return sb.toString();
    }
}
