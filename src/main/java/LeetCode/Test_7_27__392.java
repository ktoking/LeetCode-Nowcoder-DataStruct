package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Test_7_27__392 {

    /**
     * 双指针,找到一起走,找不到走长的哪个指针,最后返回指针的长度是不是记录的数字
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int s1=0,t1=0;
        while (t1<t.length()&&s1<s.length()){
            if(s.charAt(s1)==t.charAt(t1)){
                s1++;
            }
            t1++;
        }
        return s1==s.length();
    }
}
