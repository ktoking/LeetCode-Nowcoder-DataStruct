package LeetCode;

/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 */
public class Test_9_18__0106 {
    public static void main(String[] args) {
        System.out.println(compressString("aabccccc"));
    }

    /**
     * 通过判断相同位+1,然后将最后尾部拼上即可
     * @param S
     * @return
     */
    public static String compressString(String S) {
        if(S.length()<=2||S==null) return S;
        StringBuilder sb=new StringBuilder();
        int count=1;
        for (int i = 0; i < S.length()-1; i++) {
            if(S.charAt(i)==S.charAt(i+1)){
                count++;
            }else {
                sb.append(S.charAt(i)).append(count);
                count=1;
            }
        }
        sb.append(S.charAt(S.length()-1)).append(count);
        return sb.toString().length()>=S.length()?S:sb.toString();
    }
}
