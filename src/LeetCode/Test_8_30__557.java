package LeetCode;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Test_8_30__557 {
    /**
     * 反转一下然后去掉空格即可
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (String s2 : s1) {
            StringBuilder str=new StringBuilder(s2);
            sb.append(str.reverse()+" ");
        }
        return sb.toString().trim();
    }
}
