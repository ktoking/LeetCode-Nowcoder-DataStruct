package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class Test_10_27__1002 {
    /**
     * 用hash来解决
     * @param A
     * @return
     */
    public List<String> commonChars(String[] A) {
        int[] arrone=new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            arrone[A[0].charAt(i)-'a']++;
        }

        for (int i = 1; i < A.length; i++) {
            int[] arrother=new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                arrother[A[i].charAt(j)-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                arrone[j]=Math.min(arrone[j],arrother[j]);
            }
        }
        List<String> list=new ArrayList<>();
        for (int i = 0; i < arrone.length; i++) {
            while (arrone[i]!=0){
                list.add(String.valueOf((char)(i+'a')));
                arrone[i]--;
            }
        }
        return list;
    }
}
