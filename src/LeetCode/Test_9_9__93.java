package LeetCode;

import java.util.*;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 */
public class Test_9_9__93 {

    /**
     * 自己写的回溯复原ip
     */
    List<String> res1 = new LinkedList<>();
    LinkedList<String> duan = new LinkedList<>();
    public List<String> restoreIpAddresses1my(String s) {
        huisu(s,0);
        return res1;
    }
    public void huisu(String str,int index){
        if(duan.size()==4&&index==str.length()){ //满四段且用完了字符串,拼成ip加入结果集
            StringBuilder sb=new StringBuilder();
            for (String s : duan) {
                sb.append(s).append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            res1.add(sb.toString());
            return;
        }
        if(index < str.length() && duan.size() == 4)return; //满四段且没用完直接返回
        for (int i = 1; i <=3 ; i++) {                      // 三种长度的选择
            if(index+i-1>=str.length()) return;             //如果超出选择,返回
            if(i!=1&&str.charAt(index)=='0') return;        //如果长度不是第一段且选0 会出现255.01.001这种,直接返回
            String s=str.substring(index,index+i);           //将选出来的截取出来
            if(i==3&&Integer.parseInt(s)>255) return;       //长度为3的话,就要判断是否>255
            duan.add(s);
            huisu(str,index+i);
            duan.remove(duan.size()-1);
        }
    }

    /**
     * 常规回溯模板,复原IP地址
     */
    List<String> res = new LinkedList<>();
    LinkedList<String> segment = new LinkedList<>();
    public List<String> restoreIpAddresses1(String s) {
        helper(s, 0);
        return res;
    }
    void helper(String s, int start){
        if(start == s.length() && segment.size() == 4){
            StringBuilder t = new StringBuilder();
            for (String se: segment) t.append(se).append(".");
            t.deleteCharAt(t.length() - 1);
            res.add(t.toString());
            return;
        }
        if(start < s.length() && segment.size() == 4)return;
        for(int i = 1;i <= 3; i++){
            if(start + i - 1 >= s.length())return;
            if(i != 1 && s.charAt(start) == '0')return;
            String str = s.substring(start, start + i);
            if(i == 3 && Integer.parseInt(str) > 255)return;
            segment.addLast(str);
            helper(s, start + i);
            segment.removeLast();
        }
    }

    /**
     * 大神写的回溯剪枝,复原IP地址
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }
    // 需要一个变量记录剩余多少段还没被分割
    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            if (residue * 3 < len - i) {
                continue;
            }
            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }
    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }


}
