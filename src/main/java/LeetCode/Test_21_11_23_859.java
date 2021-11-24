package LeetCode;

public class Test_21_11_23_859 {

    public static void main(String[] args) {
        boolean b = buddyStrings("abcaa", "abcbb");
    }

    /**
     * 当 ss 与 goal 长度 或 词频不同，必然不为亲密字符；
     * 当「ss 与 goal 不同的字符数量为 2（能够相互交换）」或「s 与 goal 不同的字符数量为 0，但同时 ss 中有出现数量超过 2 的字符（能够相互交换）」时，两者必然为亲密字符。
     * @param s
     * @param goal
     * @return
     */
    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int[] cn1 = new int[26];
        int[] cn2 = new int[26];

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            cn1[s.charAt(i) - 'a']++;
            cn2[goal.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i)) sum++;
        }

        boolean isOk = false;
        for (int i = 0; i < cn1.length; i++) {
            if (cn1[i] != cn2[i]) return false;
            if (cn1[i] > 1) isOk = true;
        }

        return sum == 2 || (sum == 0 && isOk);
    }
}
